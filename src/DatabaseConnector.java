import jdk.nashorn.internal.codegen.CompilerConstants;

import javax.xml.crypto.Data;
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
     *
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
<<<<<<< HEAD
<<<<<<< HEAD
     *
     * @param cID cID of the subject
     * @return string of search result
     */

    static String getAllSectionInfoByClassID(Integer cID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getAllSectionInfoByClassID (?)")) {
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

    /**
     * Get an account's phone number by their ID and type
     *
     * @param ID   ID of the account
     * @param type type of the account
     * @return phone number associated with account with given ID and type
     */
    static String getPhoneByID(int ID, String type) {
        DatabaseConnector dbc = new DatabaseConnector();
        switch (type) {
            case "student":
                try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStudentPhoneByID (?)")) {
                    stmnt.setInt(1, ID);
                    if (stmnt.execute()) {
                        return printResultSet(stmnt.getResultSet()).trim();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    return "Error.";
                }
                break;
            case "staff":
                try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStaffPhoneByID (?)")) {
                    stmnt.setInt(1, ID);
                    if (stmnt.execute()) {
                        return printResultSet(stmnt.getResultSet()).trim();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    return "Error.";
                }
                break;
            default:
                System.err.println("Unknown account type: " + type);
        }
        String resultString = type + " account not found for ID " + ID;
        System.out.println(resultString);
        return resultString;
    }

    /**
     * Get class sections by subject
     *
     * @param subject the subject to get class sections for
     * @return a string representation of the section data
     */
    static String getClassesBySubject(String subject) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getAllSectionInfoBySubject (?)")) {
            stmnt.setString(1, subject);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting classes for subject " + subject + ".";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Get all class section by class ID
     *
     * @param cID the ID of the class to get sections for
     * @return a string representation of the section data
     */
    static String getClassesByID(int cID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getAllSectionInfoByClassID (?)")) {
            stmnt.setInt(1, cID);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting classes for ID " + cID + ".";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Get a class by ID and section.
     *
     * @param cID     class ID
     * @param section class section number
     * @return string representation of class with given ID and section
     */
    static String getClassByIDAndSection(int cID, int section) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getClassByIDAndSection (?, ?)")) {
            stmnt.setInt(1, cID);
            stmnt.setInt(2, section);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting classes for ID " + cID + " and section " + section + ".";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Gets all students who owe tuition
     *
     * @return string representation of student info who owe tuition
     */
    static String getStudentsOwingTuition() {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getAllStudentOwingTuition ()")) {
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting students.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Gets all students enrolled in a given class
     *
     * @param cID class to get enrolled students
     * @return string representation of student info enrolled in class cID
     */
    static String getAllStudentsEnrolledInClass(int cID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getAllStudentsEnrolledInClass (?)")) {
            stmnt.setInt(1, cID);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting students.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Gets all classes a student is enrolled in
     *
     * @param sID student to get enrolled classes
     * @return string representation of the classes student sID is enrolled in
     */
    static String getStudentSchedule(int sID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStudentSchedule (?)")) {
            stmnt.setInt(1, sID);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting schedule.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Gets all classes a staff member teaches
     *
     * @param tID staff to get taught classes
     * @return string representation of the classes staff tID teaches
     */
    static String getStaffSchedule(int tID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStaffSchedule (?)")) {
            stmnt.setInt(1, tID);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting schedule.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Enrolls a student in a class
     *
     * @param sID     the student to enroll
     * @param cID     the class to enroll in
     * @param section the section of class to enroll in
     * @return true on success, false on error
     */
    static boolean enrollInClass(int sID, int cID, int section) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL enrollInClass (?, ?, ?)")) {
            stmnt.setInt(1, sID);
            stmnt.setInt(2, cID);
            stmnt.setInt(3, section);
            stmnt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Unenrolls a student in a class
     *
     * @param sID     the student to unenroll
     * @param cID     the class to unenroll in
     * @param section the section of class to unenroll in
     * @return true on success, false on error
     */
    static boolean unEnrollInClass(int sID, int cID, int section) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL unEnrollInClass (?, ?, ?)")) {
            stmnt.setInt(1, sID);
            stmnt.setInt(2, cID);
            stmnt.setInt(3, section);
            stmnt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Pay tuition for a student.
     *
     * @param sID    student who is paying tuition
     * @param amount amount of tuition to pay
     * @return remaining amount of tuition, or null on error
     */
    static Integer payTuition(int sID, int amount) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL payTuition (?, ?, ?)")) {
            Integer leftOver;
            stmnt.setInt(1, sID);
            stmnt.setInt(2, amount);
            stmnt.registerOutParameter(3, Types.INTEGER);
            stmnt.execute();
            return stmnt.getInt(3);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets staff member/members that have a matching name
     *
     * @param name name of the staff to search for
     * @return string representation of staff data with matching name
     */
    static String getStaffByName(String name) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStaffByName (?)")) {
            stmnt.setString(1, name);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting staff.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Gets staff member/members that have a matching type
     *
     * @param type type of the staff to search for
     * @return string representation of staff data with matching name
     */
    static String getStaffByType(int type) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStaffByType (?)")) {
            stmnt.setInt(1, type);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting staff.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Changes a student's registered phone number.
     *
     * @param sID   student to change phone number
     * @param phone new phone number to change to
     * @return the new number registered, or empty string on failure
     */
    static String changeStudentPhone(int sID, String phone) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL changeStudentPhone (?, ?)")) {
            stmnt.setInt(1, sID);
            stmnt.setString(2, phone);
            stmnt.execute();
            String phoneString = getPhoneByID(sID, "student");
            if (phoneString.equals("phone: " + phone))
                return phone;
            return "Error setting phone.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Changes a student's registered password
     *
     * @param sID      student to change password
     * @param password new password to change to
     * @return true on success, false on error
     */
    static boolean changeStudentPassword(int sID, String password) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL changeStudentPassword (?, ?)")) {
            stmnt.setInt(1, sID);
            stmnt.setString(2, password);
            stmnt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Changes a class' registered instructor
     *
     * @param cID     class to change
     * @param section class section to change
     * @param tID     instructor to change to
     * @return true on success, false on error
     */
    static boolean changeClassInstructor(int cID, int section, int tID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL changeClassInstructor (?, ?, ?)")) {
            stmnt.setInt(1, cID);
            stmnt.setInt(2, section);
            stmnt.setInt(3, tID);
            stmnt.execute();
            String[] classInfo = getClassByIDAndSection(cID, section).split(" \\Q| ");
            for (String info :
                    classInfo) {
                if (info.contains("tID")) {
                    return Integer.parseInt(info.replace("tID: ", "")) == tID;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get all classes held in a given room
     *
     * @param rID room to get classes
     * @return string representation of classes held in given room
     */
    static String getRoomSchedule(int rID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getRoomSchedule (?)")) {
            stmnt.setInt(1, rID);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting room schedule.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Create a new class
     *
     * @param cID      class ID
     * @param section  section number
     * @param subject  subject type
     * @param tID      instructor ID
     * @param rID      room to be held in
     * @param days     days class will be held
     * @param start_at start time of class in string form
     * @param end_at   end time of class
     * @param capacity total number of students who can enroll in class
     * @param cost     cost of class to be added to tuition on enrollment
     * @return string representation of the new class that was created, or empty on failure
     */
    static String createClass(int cID, int section, String subject, int tID, int rID, String days, Time start_at,
                              Time end_at, int capacity, int cost) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL createClass (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmnt.setInt(1, cID);
            stmnt.setInt(2, section);
            stmnt.setString(3, subject);
            stmnt.setInt(4, tID);
            stmnt.setInt(5, rID);
            stmnt.setString(6, days);
            stmnt.setTime(7, start_at);
            stmnt.setTime(8, end_at);
            stmnt.setInt(9, capacity);
            stmnt.setInt(10, cost);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error creating class.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Get students enrolled in a specific class section
     *
     * @param cID     class ID
     * @param section section of class
     * @return string representation of students enrolled in given class and section
     */
    static String getStudentsEnrolledInSection(int cID, int section) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStudentsEnrolled (?, ?)")) {
            stmnt.setInt(1, cID);
            stmnt.setInt(2, section);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting enrolled students.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    /**
     * Log a day's attendance for a student and class + section
     *
     * @param sID      student ID to log attendance
     * @param cID      class ID to log attendance
     * @param section  section of class to log attendance
     * @param classDay day to log attendance
     * @return true on success, false on failure
     */
    static boolean logAttendance(int sID, int cID, int section, Date classDay) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL logAttendance (?, ?, ?, ?)")) {
            stmnt.setInt(1, sID);
            stmnt.setInt(2, cID);
            stmnt.setInt(3, section);
            stmnt.setDate(4, classDay);
            stmnt.execute();
            return getStudentAttendance(sID).contains(
                    "sID: " + String.valueOf(sID) +
                            " | cID: " + String.valueOf(cID) +
                            " | section: " + String.valueOf(section) +
                            " | day: " + classDay.toString()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Get student attendance for all classes.
     *
     * @param sID student ID to check attendance
     * @return string representation of student sID's attendance
     */
    static String getStudentAttendance(int sID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStudentAttendance (?)")) {
            stmnt.setInt(1, sID);
            if (stmnt.execute())
                return printResultSet(stmnt.getResultSet());
            return "Error getting student attendance.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error.";
        }
    }

    static boolean getStaffTypeById(int tID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL getStaffTypeByID (?, ?)")) {
            stmnt.setInt(1, tID);
            stmnt.registerOutParameter(2, Types.BOOLEAN);
            stmnt.execute();
            return stmnt.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    static boolean isFullTimeStudent(int sID) {
        DatabaseConnector dbc = new DatabaseConnector();
        try (CallableStatement stmnt = dbc.connection.prepareCall("CALL isFullTimeStudent (?, ?)")) {
            stmnt.setInt(1, sID);
            stmnt.registerOutParameter(2, Types.BOOLEAN);
            stmnt.execute();
            return stmnt.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
