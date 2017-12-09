import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.crypto.Data;

import java.sql.Date;
import java.sql.Time;

import static org.junit.Assert.*;

public class DatabaseConnectorTest {
    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Running SQL script...");
        ProcessBuilder pb = new ProcessBuilder(
                "bash", "-c", "cd data; mysql -u root -p --password=123 < CollegeHero.sql"
        );
        Process p = pb.start();
        p.waitFor();
        assertEquals(0, p.exitValue());
        System.out.println("DB setup complete.");
    }

    @Test
    public void createStudent() throws Exception {
        int sID = DatabaseConnector.createStudent(
                "Test Student", "pass", true, "5551231234"
        );
        assertNotEquals(-1, sID);
    }

    @Test
    public void logInAsStudent() throws Exception {
        assertEquals(1, DatabaseConnector.logInAsStudent(1, "123"));
    }

    @Test
    public void logInAsStaff() throws Exception {
        assertEquals(1, DatabaseConnector.logInAsStaff(1, "pwd"));
    }

    @Test
    public void getAccountByPhone() throws Exception {
        assertNotEquals(
                "Empty result.",
                DatabaseConnector.getAccountByPhone("5555555555", "student")
        );
        assertNotEquals(
                "Empty result.",
                DatabaseConnector.getAccountByPhone("4089751234", "staff")
        );
    }

    @Test
    public void getPhoneByID() throws Exception {
        String studentResult = DatabaseConnector.getPhoneByID(1, "student");
        assertEquals("phone: 5309665355", studentResult);

        String staffResult = DatabaseConnector.getPhoneByID(1, "staff");
        assertEquals("phone: 4089751234", staffResult);
    }

    @Test
    public void getClassesBySubject() throws Exception {
        assertEquals(3, DatabaseConnector.getClassesBySubject("math").split("\n").length);
    }

    @Test
    public void getClassesByID() throws Exception {
        assertEquals(3, DatabaseConnector.getClassesByID(1).split("\n").length);
    }

    @Test
    public void getClassByIDAndSeciton() throws Exception {
        String result = DatabaseConnector.getClassByIDAndSection(1, 1);
        assertNotEquals("Error.", result);
        assertNotEquals("Error getting classes for ID 1 and section 1.", result);
    }

    @Test
    public void getStudentsOwingTuition() throws Exception {
        String result = DatabaseConnector.getStudentsOwingTuition();
        assertNotEquals("", result);
        assertNotEquals("Error.", result);
        assertNotEquals("Error getting students.", result);
    }

    @Test
    public void getAllStudentsEnrolledInClass() throws Exception {
        assertTrue(DatabaseConnector.enrollInClass(1, 1, 1));
        String result = DatabaseConnector.getAllStudentsEnrolledInClass(1);
        assertNotEquals("", result);
        assertNotEquals("Error.", result);
        assertNotEquals("Error getting students.", result);
        assertNotEquals("Empty result.", result);
        assertTrue(DatabaseConnector.unEnrollInClass(1, 1, 1));
        assertEquals("Empty result.", DatabaseConnector.getAllStudentsEnrolledInClass(1));
    }

    @Test
    public void getStudentSchedule() throws Exception {
        assertTrue(DatabaseConnector.enrollInClass(1, 1, 1));
        String result = DatabaseConnector.getStudentSchedule(1);
        assertNotEquals("", result);
        assertNotEquals("Error.", result);
        assertNotEquals("Error getting schedule.", result);
        assertNotEquals("Empty result.", result);
        assertEquals(1, result.split("\n").length);
        assertTrue(DatabaseConnector.unEnrollInClass(1, 1, 1));
        assertEquals("Empty result.", DatabaseConnector.getStudentSchedule(1));
    }

    @Test
    public void getStaffSchedule() throws Exception {
        String result = DatabaseConnector.getStaffSchedule(1);
        assertNotEquals("", result);
        assertNotEquals("Error getting schedule.", result);
        assertNotEquals("Empty result.", result);
        assertEquals(3, result.split("\n").length);
    }

    @Test
    public void enrollAndUnenrollInClass() throws Exception {
        assertTrue(DatabaseConnector.enrollInClass(1, 1, 1));
        assertTrue(DatabaseConnector.unEnrollInClass(1, 1, 1));
    }

    @Test
    public void payTuition() throws Exception {
        assertTrue(DatabaseConnector.enrollInClass(1, 1, 1));
        Integer result = DatabaseConnector.payTuition(1, 150);
        assertNotNull(result);
        assertTrue(result.equals(0));
        assertTrue(DatabaseConnector.unEnrollInClass(1, 1, 1));
    }

    @Test
    public void getStaffByName() throws Exception {
        String result = DatabaseConnector.getStaffByName("John");
        assertNotEquals("Error.", result);
        assertNotEquals("Error getting staff.", result);
        assertNotEquals("Empty result.", result);
        assertEquals(2, result.split("\n").length);
    }

    @Test
    public void getStaffByType() throws Exception {
        String result = DatabaseConnector.getStaffByType(0);
        assertNotEquals("Error.", result);
        assertNotEquals("Error getting staff.", result);
        assertNotEquals("Empty result.", result);
        assertEquals(3, result.split("\n").length);
    }

    @Test
    public void changeStudentPhone() throws Exception {
        assertEquals("5303435544", DatabaseConnector.changeStudentPhone(1, "5303435544"));
    }

    @Test
    public void changeStudentPassword() throws Exception {
        assertTrue(DatabaseConnector.changeStudentPassword(1, "xyz"));
        assertEquals(1, DatabaseConnector.logInAsStudent(1, "xyz"));
        assertTrue(DatabaseConnector.changeStudentPassword(1, "123"));
    }

    @Test
    public void changeClassInstructor() throws Exception {
        assertTrue(DatabaseConnector.changeClassInstructor(1, 1, 1));
    }

    @Test
    public void getRoomSchedule() throws Exception {
        String result = DatabaseConnector.getRoomSchedule(1);
        assertNotEquals("", result);
        assertNotEquals("Error.", result);
        assertNotEquals("Error getting room schedule.", result);
        assertEquals(2, result.split("\n").length);
    }

    @Test
    public void createClass() throws Exception {
        String result = DatabaseConnector.createClass(99, 1, "CS", 2, 2, "W",
                Time.valueOf("00:00:00"), Time.valueOf("00:00:01"), 10, 150);
        assertNotEquals("Error.", result);
        assertNotEquals("Error creating class.", result);
        assertEquals(1, result.split("\n").length);
    }

    @Test
    public void getStudentsEnrolledInSection() throws Exception {
        assertTrue(DatabaseConnector.enrollInClass(1, 1,1 ));
        assertTrue(DatabaseConnector.enrollInClass(2, 1, 1));
        String result = DatabaseConnector.getStudentsEnrolledInSection(1, 1);
        assertNotEquals("Error.", result);
        assertNotEquals("Error getting enrolled students.", result);
        assertEquals(2, result.split("\n").length);
        assertTrue(DatabaseConnector.unEnrollInClass(1, 1,1 ));
        assertTrue(DatabaseConnector.unEnrollInClass(2, 1, 1));
    }

    @Test
    public void logAndGetStudentAttendance() throws Exception {
        assertTrue(DatabaseConnector.logAttendance(1, 1, 1, Date.valueOf("2017-01-01")));
        assertTrue(DatabaseConnector.logAttendance(1, 4, 1, Date.valueOf("2017-01-02")));

        String getResult = DatabaseConnector.getStudentAttendance(1);
        assertNotEquals("Error.", getResult);
        assertNotEquals("Error getting student attendance.", getResult);
        assertEquals(2, getResult.split("\n").length);
    }
}
