import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
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
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bank Management System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.next();
                    System.out.print("Enter initial balance: $");
                    double initialBalance = scanner.nextDouble();

                    BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);
                    accounts.add(account);
                    System.out.println("Account created successfully.");
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.next();
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(depositAccountNumber)) {
                            acc.deposit(depositAmount);
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.next();
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(withdrawAccountNumber)) {
                            acc.withdraw(withdrawAmount);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String displayAccountNumber = scanner.next();

                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber().equals(displayAccountNumber)) {
                            acc.displayAccountInfo();
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Bank Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
