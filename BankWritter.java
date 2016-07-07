import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankWritter extends JPanel {
	private int width = 400,
			height = 400;
	private BankAccount bankAccount1;
	private BankAccount bankAccount2;
	private String lastTransaction = "";

	public BankWritter(String title, BankAccount bankAccount1, BankAccount bankAccount2) {
		this.bankAccount1 = bankAccount1;
		this.bankAccount2 = bankAccount2;
		JFrame frame = new JFrame(title);
		frame.getContentPane().add(this);
		frame.setSize(width, height);
		//		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		int textMargin = 50;
		int textBaseline = 50;
		g.setColor(Color.BLACK);
		
		g.drawString("Account 1 Name: " + bankAccount1.getAccountName(), textMargin, textBaseline);
		g.drawString("Account 2 Name: " + bankAccount2.getAccountName(), textMargin, textBaseline + 20);
		g.drawString("Current balance of first account = $" + unconvert(bankAccount1.getBalance()), textMargin, textBaseline + 40);
		g.drawString("Current balance of second account = $" + unconvert(bankAccount2.getBalance()), textMargin, textBaseline + 60);
		
		g.setColor(Color.RED);
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
		g.setFont(newFont);
		g.drawString(lastTransaction, textMargin, textBaseline+100);
	}

	public void showTransaction(String message, int amount) {
		lastTransaction = message + " " + unconvert(amount);
		this.repaint();
	}
	public void showTransaction(String message) {
		lastTransaction = message;
		this.repaint();
	}

	private String unconvert(int i) {
		double dollarCents = i / 100.0;
		return new DecimalFormat("0.00").format(dollarCents);
	}
}