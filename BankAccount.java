import javax.swing.JOptionPane;

public class BankAccount {

	private int initial_balance;
	private int balance;
	private int amount = 0;
	private String accountName = "";

	public BankAccount(int initial_balance, String accountName) {
		
		this.accountName = accountName;
		
		if (initial_balance >= 0) {
			balance = initial_balance;
		} else {
			balance = 0;
		}
	}
	public boolean deposit(int amount) {
		boolean result = false;
		if (amount > 0) {
			balance += amount;
			result = true;
		} else {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		return result;
	}
	public boolean withdraw(int amount) {
		boolean result = false;
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			result = true;
		} else {
			JOptionPane.showMessageDialog(null, "ERROR:Amount either ingored or exceeds the balance");
		}
		return result;
	}
	public int getBalance() {

		return balance;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}