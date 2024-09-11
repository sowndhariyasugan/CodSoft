package ATM;

public class User {
	private long AccountNo;
	private int Pin;
	private double Balance;
	
	public User(long accountNo, int pin) {
		super();
		AccountNo = accountNo;
		Pin = pin;
		Balance = 200.0;
	}

	public int getPin() {
		return Pin;
	}

	public void setPin(int pin) {
		Pin = pin;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public long getAccountNo() {
		return AccountNo;
	}

	@Override
	public String toString() {
		return "User [AccountNo=" + AccountNo + ", Balance=" + Balance + "]";
	}
	
	
	
}
