import java.io.Console;

public class loginsystem {
    public static void main(String[] args) {
        String correctUsername = "admin";
        String correctPassword = "secure123";

        Console console = System.console();
        if (console == null) {
            System.out.println("ERROR: Console not available. Run this program in a terminal.");
            return;
        }

        for (int attempts = 1; attempts <= 5; attempts++) {
            String username = console.readLine("Username: ");
            char[] passwordArray = console.readPassword("Password: ");
            String password = new String(passwordArray);

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("\nLogin successful. Welcome, " + username + "!");
                return;
            } else {
                System.out.println("\nInvalid credentials. Attempt " + attempts + " of 5.");
                if (attempts < 5) {
                    System.out.println("Try again.\n");
                }
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Unexpected error.");
            }
        }

        System.out.println("\nToo many failed attempts. Access denied.");
    }
}
