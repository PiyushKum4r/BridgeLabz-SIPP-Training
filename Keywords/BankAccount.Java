class BankAccount {
    // Static variable shared across all instances
    static String bankName = "Global Bank";
    static int totalAccounts = 0;

    // Instance variables
    private String accountHolderName;
    private final int accountNumber; // final variable cannot be changed
    private double balance;

    // Constructor
    BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        // Using 'this' to resolve ambiguity
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        totalAccounts++; // Update static counter
    }

    // Static method to return total accounts
    public static void getTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Method to display account details
    public void displayDetails() {
        if (this instanceof BankAccount) { // instanceof check
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        } else {
            System.out.println("Invalid account object.");
        }
    }
}

// Main class to test the BankAccount class
public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1001, 5000.0);
        BankAccount acc2 = new BankAccount("Bob", 1002, 3000.0);

        acc1.deposit(1000);
        acc1.withdraw(2000);
        acc1.displayDetails();

        acc2.displayDetails();

        // Static method call
        BankAccount.getTotalAccounts();
    }
}
