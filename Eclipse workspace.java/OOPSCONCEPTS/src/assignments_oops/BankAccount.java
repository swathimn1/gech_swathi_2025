package assignments_oops;

public class BankAccount {
	private String accountNumber;
	private String accountHolderName;
	private double balance;

	public BankAccount(String accountNumber, String accountHolderName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Deposited:"+amount);
		}
		else {
			System.out.println("Deposit amount must be positive.");
		}
	}
	public void withdraw(double amount) {
		if(amount <= 0) {
		 System.out.println("withdrawl amount must be positive.");	
		}
		else if(amount >balance) {
			System.out.println("Insufficient amount");
		}
		else {
			balance-=amount;
			System.out.println("Withdrawn:"+amount);
		}
	}
	public double getBalance() {
		return balance;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}

	public static void main(String[] args) {
		BankAccount account=new BankAccount("1234567890","Swathi",5000);
		System.out.println(account.getAccountHolderName());
		System.out.println(account.getBalance());
		account.deposit(2000);
		account.withdraw(1000);
		account.withdraw(7000);
		System.out.println(account.getBalance());
		

	}

}
