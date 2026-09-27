import java.util.Scanner;

/**

 * This program asks the user for lunch item

 * and calculates the time it needs to be mocrowaved.

 * @author Yoma Ozoh

 * @version 1.0

 * @since 2026-09-24

 */

public class Microwave {
public static void main(String[] args) {
        // Base heating times in seconds
        final int SUB_TIME = 60;
        final int PIZZA_TIME = 45;
        final int SOUP_TIME = 105;
        final int MAX_QUANTITY = 3;

        Scanner scanner = new Scanner(System.in);
        // set base time to 0
        int baseTime = 0;
        // ask user to enter their lunch item
        System.out.print("Please enter your lunch item (Sub, Pizza, Soup): ");
        String itemInput = scanner.nextLine().trim();

        // Determine base time based on user input
        if (itemInput.equalsIgnoreCase("Sub")) {
            baseTime = SUB_TIME;
        } else if (itemInput.equalsIgnoreCase("Pizza")) {
            baseTime = PIZZA_TIME;
        } else if (itemInput.equalsIgnoreCase("Soup")) {
            baseTime = SOUP_TIME;
        } else {
            System.out.println("Invalid item selected.");
            scanner.close();
            return;
        }

        System.out.print("How many items are you heating up? ");
        double totalTime = 0.0;
        // if user doesn't input a valid integer
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number (1, 2, or 3).");
            scanner.close();
            return;
        }
        int quantity = scanner.nextInt();
        // start try catch
        try {
            // Calculate total heating time based on quantity
            if (quantity == 1) {
                totalTime = baseTime;
            } else if (quantity == 2) {
                totalTime = baseTime * 1.5;
            } else if (quantity == 3) {
                totalTime = baseTime * 2.0;
            } else {
                // tell user they can't input more than the maximum
                System.out.println("Sorry, the maximum number of items is " + MAX_QUANTITY + ".");
                scanner.close();
                scanner.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.close();
            return;
        }

        System.out.println("You may heat up for: " + totalTime + " seconds.");
        scanner.close();
    }
}