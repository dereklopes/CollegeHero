import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;
import java.io.FileInputStream;

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
     * @param SQLStmnt - SQL statement to execute
     * @return result of the execute statement, or null if empty or error
     */
    ResultSet executeStatement(String SQLStmnt) {
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
}
