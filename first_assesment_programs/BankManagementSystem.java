import java.io.*;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

public class BankManagementSystem {

    private static final String FILE_PATH = "bank_accounts.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bank Management System Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Account Info");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performDeposit();
                    break;

                case 2:
                    performWithdraw();
                    break;

                case 3:
                    displayAccountInfo();
                    break;

                case 4:
                    System.out.println("Exiting Bank Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void performDeposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter deposit amount: $");
        double depositAmount = scanner.nextDouble();

        try {
            BankAccount account = findAccount(accountNumber);
            if (account != null) {
                account.deposit(depositAmount);
                updateAccountFile(account);
            } else {
                System.out.println("Account not found.");
            }
        } catch (IOException e) {
            System.out.println("Error accessing file: " + e.getMessage());
        }
    }

    private static void performWithdraw() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter withdrawal amount: $");
        double withdrawalAmount = scanner.nextDouble();

        try {
            BankAccount account = findAccount(accountNumber);
            if (account != null) {
                account.withdraw(withdrawalAmount);
                updateAccountFile(account);
            } else {
                System.out.println("Account not found.");
            }
        } catch (IOException e) {
            System.out.println("Error accessing file: " + e.getMessage());
        }
    }

    private static void displayAccountInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();

        try {
            BankAccount account = findAccount(accountNumber);
            if (account != null) {
                account.displayAccountInfo();
            } else {
                System.out.println("Account not found.");
            }
        } catch (IOException e) {
            System.out.println("Error accessing file: " + e.getMessage());
        }
    }

    private static BankAccount findAccount(String accountNumber) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(accountNumber)) {
                    return new BankAccount(parts[0], parts[1], Double.parseDouble(parts[2]));
                }
            }
        }
        return null;
    }

    private static void updateAccountFile(BankAccount updatedAccount) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(updatedAccount.getAccountNumber() + "," +
                    updatedAccount.getAccountHolder() + "," +
                    updatedAccount.getBalance());
            writer.newLine();
        }
    }
}
