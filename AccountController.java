import javax.swing.JOptionPane;

public class AccountController {

	private BankAccount bankAccount1;
	private BankAccount bankAccount2;
	private BankAccount bankAccount;
	private BankReader bankReader;
	private BankWritter bankWriter;

	public AccountController(BankAccount bankAccount1,BankAccount bankAccount2, BankReader bankReader, BankWritter bankWriter) {
		this.bankAccount1 = bankAccount1;
		this.bankAccount2 = bankAccount2;
		this.bankReader = bankReader;
		this.bankWriter = bankWriter;
	}

	public void proccessTransaction() {
		String accountName = bankReader.readAccountHolder();
		if(accountName.equalsIgnoreCase("Account1")) bankAccount = bankAccount1;
		else if(accountName.equalsIgnoreCase("Account2")) bankAccount = bankAccount2;
		else {
			bankAccount = null;
			JOptionPane.showMessageDialog(null, "Error, this Account doesen't exists");
			System.exit(0);
		}
		
		char command = bankReader.readCommand("Command (d,w,q) and amount: ");
		if (command == 'Q') System.exit(0);
		else {
			if (command == 'D') {
				int amount = bankReader.readAmount();
				boolean ok = bankAccount.deposit(amount);
				if (ok) bankWriter.showTransaction("Deposit of $", amount);
				else bankWriter.showTransaction("Deposit invalid");
			} else if (command == 'W') {
				int amount = bankReader.readAmount();
				boolean ok = bankAccount.withdraw(amount);
				if (ok) bankWriter.showTransaction("Withdraw of $", amount);
				else bankWriter.showTransaction("Withdraw invalid");
			} else {
				bankWriter.showTransaction("Illegal command " + command);
            this.proccessTransaction();
			}
			this.proccessTransaction();
		}

	}

	public static void main(String[] args) {
		
		BankAccount bankAccount1 = new BankAccount(0, "Account1");
		BankAccount bankAccount2 = new BankAccount(0, "Account2");
		BankReader bankReader = new BankReader();
		BankWritter bankWritter = new BankWritter("Bank Writer", bankAccount1, bankAccount2);
		
		AccountController accountController = new AccountController(bankAccount1, bankAccount2, bankReader, bankWritter);

		accountController.proccessTransaction();
	}
}