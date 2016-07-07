import javax.swing.JOptionPane;

public class BankReader {
	private String inputLine = "";

	public char readCommand(String message) {
		inputLine = JOptionPane.showInputDialog(message).trim().toUpperCase();
		return inputLine.charAt(0);
	}
	public int readAmount() {
		int answer = 0;
		String s = inputLine.substring(1, inputLine.length());
		s = s.trim();
		if (s.length() > 0) {
			double dollarCents = new Double(s).doubleValue();
			answer = (int) dollarCents * 100;
		} else JOptionPane.showMessageDialog(null, "BankReader error: no number for transaction---zero used");
		return answer;
	}
	
	public String readAccountHolder(){
		return JOptionPane.showInputDialog("Please write name of Account");
	}
}