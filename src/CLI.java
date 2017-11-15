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
                            "[2] Login as staff\n" +
                            "[3] Register as new student\n" +
                            "[4] Search for ID by phone nubmer\n" +
                            "[5] Login as admin"
            );
            Integer[] options = {0, 1, 2, 3, 4, 5};
            Integer decision = getOption(options);
            switch (decision) {
                case 0:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                case 1:
                    ID = logIn("student");
                    if (ID > 0) {
                        loggedIn = true;
                        loginType = "student";
                    }
                    break;
                case 2:
                    ID = logIn("staff");
                    if (ID > 0) {
                        loggedIn = true;
                        loginType = "staff";
                    }
                    break;
                case 3:
                    ID = createStudent();
                    if (ID > 0) {
                        loggedIn = true;
                        loginType = "student";
                    }
                    break;
                default:
                    System.out.println("This feature is not implemented yet");
            }
        }

        // Studnet action screen
        if (loginType.equals("student")) {
            clearConsole();
            System.out.printf("--- Logged in as student ID: %s ---\n", ID.toString());
            System.out.println("Action phase, later you can do things like enroll in a class");
        }
        // Teacher action screen
        if (loginType.equals("staff")) {
            clearConsole();
            System.out.printf("--- Logged in as staff ID: %s ---\n", ID.toString());
            System.out.println("Action phase, later you can do things like take attendance");
        }
        // Admin action screen
        if (loginType.equals("admin")) {
            clearConsole();
            System.out.printf("--- Logged in as admin ID: %s ---\n", ID.toString());
            System.out.println("Action phase, later you can do things like create a class");
        }
        // SHOULDN'T GET IN HERE
        if (loginType.equals("none")) {
            clearConsole();
            System.err.println("Somehow got past login screen");
        }
    }

    /**
     * Log into an account, prompting for a password and verifying against DB.
     * @param type the type of account to log into (ex. student, staff, admin)
     * @return ID of the account logged into, or -1 on error
     */
    private static int logIn(String type) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your " + type + " ID: ");
        Integer ID = scanner.nextInt();
        System.out.printf("Enter your password: ");
        scanner.nextLine();
        String password = getPassword();
        switch (type) {
            case "student":
                if (ID == DatabaseConnector.logInAsStudent(ID, password)) {
                    System.out.println("Logged in as student " + ID.toString());
                    return ID;
                }
                break;
            case "staff":
                if (ID == DatabaseConnector.logInAsStaff(ID, password)) {
                    System.out.println("Logged in as staff " + ID.toString());
                    return ID;
                }
                break;
            case "admin":
                break;
            default:
                System.out.println("Unknown account type: " + type);
                return -1;
        }
        System.out.println("Failed to log in.");
        return -1;
    }

    /**
     * Create a new student user
     *
     * @return the student ID of the newly created user, or -1 on error
     */
    private static int createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your full name: ");
        String name = scanner.nextLine();
        System.out.printf("Enter your password: ");
        String password = getPassword();
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
     * Clears the screen
     */
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Gets a password from the console without echoing the typed characters
     * Alternatively (when running not in console) it prompts normally
     *
     * @return String password entered
     */
    private static String getPassword() {
        try {
            char[] pwdChars = System.console().readPassword();
            StringBuilder bldr = new StringBuilder("");
            for (char character :
                    pwdChars) {
                bldr.append(character);
            }
            return bldr.toString();
        } catch (NullPointerException e) {
            // No console available, just get with stdin
            // Happens when running in an IDE
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
    }
}
