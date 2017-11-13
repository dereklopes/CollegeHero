import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        boolean exit = false;
        boolean loggedIn = false;
        String loginType = "none";
        Integer ID = -1;
        // Log in screen
        while (!exit && !loggedIn) {
            System.out.println("\n~~~ CollegeHero v0.1 - CS157A Fall 2017 ~~~\n");
            System.out.println("Please sign in:");
            System.out.println(
                    "[0] Exit\n" +
                            "[1] Login as student\n" +
                            "[2] Login as teacher\n" +
                            "[3] Register as new student\n" +
                            "[4] Search for ID by phone nubmer"
            );
            Integer[] options = {0, 1, 2, 3, 4};
            Integer decision = getOption(options);
            switch (decision) {
                case 0:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                case 3:
                    ID = createStudent();
                    if (ID > 0) {
                        loggedIn = true;
                        loginType = "s";
                    }
                    break;
                default:
                    System.out.println("This feature is not implemented yet");
            }
        }

        // Studnet action screen
        if (loginType.equals("s")) {
            clearConsole();
            System.out.printf("--- Logged in as student ID: %s ---\n", ID.toString());
            System.out.println("Action phase, later you can do things like enroll in a class");
        }
        // Teacher action screen
        if (loginType.equals("t")) {
            clearConsole();
            System.out.printf("--- Logged in as student ID: %s ---\n", ID.toString());
            System.out.println("Action phase, later you can do things like take attendance");
        }
        // Admin action screen
        if (loginType.equals("a")) {
            clearConsole();
            System.out.printf("--- Logged in as student ID: %s ---\n", ID.toString());
            System.out.println("Action phase, later you can do things like create a class");
        }
    }

    /**
     * Prompts for input and gets a valid response
     *
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
     * Prints all registered students and their information
     */
    private static void getStudents() {
        DatabaseConnector.printAllFromTable("student");
    }

    /**
     * Prints all staff members and their information
     */
    private static void getStaff() {
        DatabaseConnector.printAllFromTable("staff");
    }

    private static int createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your full name: ");
        String name = scanner.nextLine();
        // TODO: Change password retrieval to not show characters inputted
        System.out.printf("Enter your password: ");
        String password = scanner.nextLine();
        System.out.printf("Enter your sex (1 for male, 0 for female): ");
        int sexInput = getOption(new Integer[]{0, 1});
        boolean sex = true;
        if (sexInput == 0)
            sex = false;
        System.out.printf("Enter your phone number (ex. 5555555555): ");
        String phone = scanner.nextLine();
        Integer sID = DatabaseConnector.createStudent(name, password, sex, phone);
        if (sID > 0) {
            System.out.println("Success. Your student ID is: " + sID.toString());
            return sID;
        }
        System.out.println("There was an error creating your account.");
        return -1;
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}