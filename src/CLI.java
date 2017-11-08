import java.sql.ResultSet;
import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n~~~ CollegeHero v0.1 - CS157A Fall 2017 ~~~\n");
            System.out.println("What would you like to do:");
            System.out.println("[0] Exit\n[1] Get all students");
            Integer[] options = {0, 1};
            Integer decision = getOption(options);
            switch (decision) {
                case 0:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                case 1:
                    getStudents();
                    break;
            }
        }
    }

    /**
     * Prompts for input and gets a valid response
     * @param options - integer array to validate input against
     * @return user's choice, validated
     */
    private static Integer getOption(Integer[] options) {
        boolean isValid = false;
        Integer input = -1;
        Scanner scanner = new Scanner(System.in);

        while (!isValid) {
            System.out.printf("Enter an option [");
            for (int i = 0; i < options.length - 1; i++) {
                System.out.printf("%d, ", options[i]);
            }
            System.out.printf("%d]: ", options[options.length - 1]);

            input = scanner.nextInt();
            for (Integer num : options) {
                if (num.equals(input))
                    isValid = true;
            }
        }
        return input;
    }

    /**
     * Prints all books and book information in library
     */
    private static void getStudents() {
        DatabaseConnector dbc = new DatabaseConnector();
        ResultSet result = dbc.executeStatement("SELECT * FROM student");
        System.out.println("All students:");
        DatabaseConnector.printResultSet(result);
    }
}