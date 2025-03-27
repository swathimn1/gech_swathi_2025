package bankaccount;

public class BankAccount {

	
	    // Private fields
	    private String accountNumber;
	    private String accountHolderName;
	    private double balance;

	    // Constructor
	    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.balance = Math.max(initialBalance, 0); // Ensuring no negative balance
	    }

	    // Method to deposit money
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited: "+ amount);
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    // Method to withdraw money
	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawn: " + amount);
	        } else {
	            System.out.println("Insufficient balance or invalid amount.");
	        }
	    }

	    // Method to display account details
	    public void displayAccountInfo() {
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Account Holder: " + accountHolderName);
	        System.out.println("Balance: " + balance);
	    }

	    // Getter for balance
	    public double getBalance() {
	        return balance;
	    }

	    public static void main(String[] args) {
	        // Creating a BankAccount object
	        BankAccount account = new BankAccount("123456", "John Doe", 500.0);

	        // Performing transactions
	        account.displayAccountInfo();
	        account.deposit(200);
	        account.withdraw(100);
	        account.withdraw(700); // Should show insufficient balance
	        account.displayAccountInfo();
	    }
	}