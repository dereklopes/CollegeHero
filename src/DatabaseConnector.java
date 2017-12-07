import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

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
    static ArrayList<HashMap<String, String>> createListFromResultSet(ResultSet result) {
        try {
            ResultSetMetaData rsmd = result.getMetaData();
            int columnCount = rsmd.getColumnCount();
            ArrayList<HashMap<String, String>> resultList = new ArrayList<>();
            while (result.next()) {
                HashMap<String, String> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = result.getString(i);
                    row.put(rsmd.getColumnName(i), columnValue);
                }
                resultList.add(row);
            }
            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Create a string representation of a ResultSet object (as to be displayed later)
     * @param result - the result set to create a string from
     * @return A string representation of the result set
     */
    private static String getStringFromResultSet(ResultSet result) {
        try {
            if (result == null) {
                return "";
            }
            ResultSetMetaData rsmd = result.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            ArrayList<HashMap<String, String>> resultList = DatabaseConnector.createListFromResultSet(result);
            if (resultList == null) {
                System.out.println("Error getting result data.");
                return "Error getting result data.";
            }
            if (resultList.isEmpty()) {
                System.out.println("Empty result.");
                return "Empty result.";
            }
            StringBuilder bldr = new StringBuilder();
            for (HashMap<String, String> row :
                    resultList) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) bldr.append(" | ");
                    String columnValue = row.get(rsmd.getColumnName(i));
                    bldr.append(rsmd.getColumnName(i));
                    bldr.append(": ");
                    bldr.append(columnValue);
                }
                bldr.append("\n");
            }
            return bldr.toString();
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
    private static String printResultSet(ResultSet result) {
        String resultString = DatabaseConnector.getStringFromResultSet(result);
        System.out.println(resultString);
        return resultString;
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
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL createStudent (?, ?, ?, ?, ?)")) {
            stmnt.setString(1, name);
            stmnt.setString(2, password);
            stmnt.setBoolean(3, sex);
            stmnt.setString(4, phone);
            stmnt.registerOutParameter(5, Types.INTEGER);
            stmnt.execute();
            return stmnt.getInt(5);
        } catch (SQLException e) {
            if (e.getSQLState().equals("23000"))
                System.out.println("Phone number " + phone + " already registered!");
            else
                e.printStackTrace();
            return -1;
        }
    }

    /**
     * Login as a student
     *
     * @param sID      tID of student to login as
     * @param password password of the student
     * @return sID of student if successful, -1 if unsuccessful
     */
    static int logInAsStudent(Integer sID, String password) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStudentPasswordByID (?, ?)")) {
            stmnt.setInt(1, sID);
            stmnt.registerOutParameter(2, Types.VARCHAR);
            stmnt.execute();
            if (stmnt.getString(2) != null && stmnt.getString(2).equals(password)) {
                return sID;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *
     * @param cID cID of the subject
     * @return string of search result
     */

    static String getAllSectionInfoByClassID(Integer cID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getAllSectionByClassID (?)")) {
            stmnt.setInt(1, cID);
            if (stmnt.execute()) {
                return printResultSet(stmnt.getResultSet());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *
     * @param subject subject that is trying to be searched
     * @return All class info from the subject
     */

    static String getAllSectionInfoBySubject(String subject) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getAllSectionInfoBySubject (?)")) {
            stmnt.setString(1, subject);
            if (stmnt.execute()) {
                return printResultSet(stmnt.getResultSet());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Login as a staff memeber
     *
     * @param tID      tID of student to login as
     * @param password password of the staff
     * @return tID of staff if successful, -1 if unsuccessful
     */
    static int logInAsStaff(Integer tID, String password) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStaffPasswordByID (?, ?)")) {
            stmnt.setInt(1, tID);
            stmnt.registerOutParameter(2, Types.VARCHAR);
            stmnt.execute();
            if (stmnt.getString(2).equals(password)) {
                return tID;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * Get account info by type and phone number
     *
     * @param phone the phone number to search for
     * @param type  the type of account to search for (ex. student or staff)
     */
    static String getAccountByPhone(String phone, String type) {
        DatabaseConnector dbc = new DatabaseConnector();
        switch (type) {
            case "student":
                try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStudentIDByPhone (?)")) {
                    stmnt.setString(1, phone);
                    if (stmnt.execute()) {
                        return printResultSet(stmnt.getResultSet());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    return "";
                }
                break;
            case "staff":
                try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStaffIDByPhone (?)")) {
                    stmnt.setString(1, phone);
                    if (stmnt.execute()) {
                        return printResultSet(stmnt.getResultSet());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    return "";
                }
                break;
            default:
                System.err.println("Unknown account type: " + type);
        }
        String resultString = type + " account not found for phone number " + phone;
        System.out.println(resultString);
        return resultString;
    }

    static void printAllFromTable(String table) {
        DatabaseConnector dbc = new DatabaseConnector();
        ResultSet result = dbc.executeStatement("SELECT * FROM " + table);
        System.out.println("All " + table + ":");
        DatabaseConnector.printResultSet(result);
    }
}
