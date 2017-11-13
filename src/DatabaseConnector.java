import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

class DatabaseConnector {

    private Connection connection;

    DatabaseConnector() {
        connection = getConnection();
    }

    /**
     * Makes and returns a connection to the MySQL database through jdbc
     *
     * @return connection to MySQL database, or null on error
     */
    private Connection getConnection() {
        try {
            // get db config
            InputStream input = new FileInputStream("config.properties");
            Properties prop = new Properties();
            prop.load(input);

            // make db connection
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/" + prop.getProperty("database") +
                            "?user=" + prop.getProperty("dbuser") +
                            "&password=" + prop.getProperty("dbpassword") +
                            "&useSSL=false"
            );
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (IOException ex) {
            System.out.println("Failed loading config file.");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Execute a SQL statement on the database
     *
     * @param SQLStmnt - SQL statement to execute
     * @return result of the execute statement, or null if empty or error
     */
    private ResultSet executeStatement(String SQLStmnt) {
        Statement stmnt;
        try {
            stmnt = connection.createStatement();
            if (stmnt.execute(SQLStmnt)) {
                ResultSet rs = stmnt.getResultSet();
                // if set is empty, return null
                if (!rs.next())
                    return null;
                return rs;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

    /**
     * Create a list of rows from a ResultSet object for easier manipulation.
     * Each row becomes an element in the list. Each element is a map with
     * the keys being the column names.
     *
     * @param result - the result set to create a list from
     * @return A list of hash maps with the column names as keys.
     * Each element in the list represents one row.
     */
    private static ArrayList<HashMap<String, String>> createListFromResultSet(ResultSet result) {
        try {
            ResultSetMetaData rsmd = result.getMetaData();
            int columnCount = rsmd.getColumnCount();
            ArrayList<HashMap<String, String>> resultList = new ArrayList<>();
            do {
                HashMap<String, String> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = result.getString(i);
                    row.put(rsmd.getColumnName(i), columnValue);
                }
                resultList.add(row);
            } while (result.next());
            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Prints all attributes of a result set
     *
     * @param result - the result set to print out
     */
    private static void printResultSet(ResultSet result) {
        try {
            if (result == null) {
                System.out.println("Empty result.");
                return;
            }
            ResultSetMetaData rsmd = result.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            ArrayList<HashMap<String, String>> resultList = DatabaseConnector.createListFromResultSet(result);
            if (resultList == null) {
                System.out.println("Error getting result data.");
                return;
            }
            if (resultList.isEmpty()) {
                System.out.println("Empty result.");
                return;
            }
            for (HashMap<String, String> row :
                    resultList) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(" | ");
                    String columnValue = row.get(rsmd.getColumnName(i));
                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                }
                System.out.println("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Create a new student user
     *
     * @param name     name of the student
     * @param password password for logging in
     * @param sex      boolean, 1 for male, 0 for female
     * @param phone    phone number (ex. 5555555555, maximum of 15 digits
     * @return sID of new user, or -1 on error
     */
    static int createStudent(String name, String password, boolean sex, String phone) {
        DatabaseConnector dbc = new DatabaseConnector();
        try {
            CallableStatement stmnt = dbc.connection.prepareCall("CALL createStudent (?, ?, ?, ?, ?)");
            stmnt.setString(1, name);
            stmnt.setString(2, password);
            stmnt.setBoolean(3, sex);
            stmnt.setString(4, phone);
            stmnt.registerOutParameter(5, Types.INTEGER);
            stmnt.execute();
            return stmnt.getInt(5);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    static void printAllFromTable(String table) {
        DatabaseConnector dbc = new DatabaseConnector();
        ResultSet result = dbc.executeStatement("SELECT * FROM " + table);
        System.out.println("All " + table + ":");
        DatabaseConnector.printResultSet(result);
    }
}
