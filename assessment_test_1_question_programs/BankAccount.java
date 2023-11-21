public class BankAccount {
    private static int nextAccountNumber = 1000; // Initial account number for the first depositor
    private int accountNumber;
    private String accountHolderName;
    private String address;
    private String accountType;
    private double balance;
    private int numberOfTransactions;

    public BankAccount(String accountHolderName, String address, String accountType) {
        this.accountNumber = nextAccountNumber++;
        this.accountHolderName = accountHolderName;
        this.address = address;
        this.accountType = accountType;
        this.balance = 0.0;
        this.numberOfTransactions = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: AC" + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Address: " + address);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
        System.out.println("Number of Transactions: " + numberOfTransactions);
        System.out.println("-------------------------------");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            numberOfTransactions++;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            numberOfTransactions++;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void changeAddress(String newAddress) {
        address = newAddress;
        System.out.println("Address updated successfully.");
    }
}