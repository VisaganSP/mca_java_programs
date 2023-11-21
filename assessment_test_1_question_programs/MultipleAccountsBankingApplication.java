import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultipleAccountsBankingApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        int choice;
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Create a New Bank Account");
            System.out.println("2. Display All Accounts Information");
            System.out.println("3. Select an Account and Perform Operations");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Dynamic input for account creation
                    System.out.println("Enter details to create a new bank account:");
                    System.out.print("Account Holder Name: ");
                    String holderName = scanner.nextLine();

                    System.out.print("Address: ");
                    String accountAddress = scanner.nextLine();

                    System.out.print("Account Type (Savings/Checking): ");
                    String accountType = scanner.nextLine();

                    BankAccount newAccount = new BankAccount(holderName, accountAddress, accountType);
                    accounts.add(newAccount);
                    System.out.println("New account created successfully.");
                    break;
                case 2:
                    // Display all accounts information
                    for (BankAccount account : accounts) {
                        account.displayAccountInfo();
                    }
                    break;
                case 3:
                    // Perform operations on a selected account
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available. Please create an account first.");
                        break;
                    }

                    System.out.println("Select an account:");
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". AC" + accounts.get(i).getAccountNumber());
                    }

                    System.out.print("Enter the account number to perform operations: ");
                    int selectedAccountIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (selectedAccountIndex >= 1 && selectedAccountIndex <= accounts.size()) {
                        performOperations(accounts.get(selectedAccountIndex - 1));
                    } else {
                        System.out.println("Invalid account selection.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 4);

        scanner.close();
    }

    private static void performOperations(BankAccount account) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Choose an operation for AC" + account.getAccountNumber() + ":");
            System.out.println("1. Display Account Information");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change Address");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    account.displayAccountInfo();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    account.changeAddress(newAddress);
                    break;
                case 5:
                    System.out.println("Returning to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
