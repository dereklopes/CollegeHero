import java.sql.*;

public class DatabaseConnector {

    private Connection connection;

    public DatabaseConnector() {
        connection = getConnection();
    }

    /**
     * Makes and returns a connection to the MySQL database through jdbc
     * @return connection to MySQL database, or null on error
     */
    private Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost/LIBRARY?" + "user=root&password=123");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Execute a SQL statement on the database
     * @param SQLStmnt - SQL statement to execute
     * @return result of the execute statement, or null if error
     */
    ResultSet executeStatement(String SQLStmnt) {
        Statement stmnt = null;
        try {
            stmnt = connection.createStatement();
            if (stmnt.execute(SQLStmnt)) {
                return stmnt.getResultSet();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }
}
