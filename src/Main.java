import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BakeShop bakeShop = new BakeShop();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            bakeShop.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    bakeShop.customizeCake();
                    break;
                case 2:
                    bakeShop.customizePastries();
                    break;
                case 3:
                    bakeShop.customizeBread();
                    break;
                case 4:
                    bakeShop.displayOrderSummary();
                    break;
                case 5:
                    bakeShop.printNextOrder();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        } while (choice != 6);

        bakeShop.displayOrderSummary();
    }
}