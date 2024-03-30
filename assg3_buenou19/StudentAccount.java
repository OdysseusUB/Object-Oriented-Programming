/**
 *@Author - Ulysses Bueno
 */
package assg3_buenou19;

public class StudentAccount implements Comparable <StudentAccount> {

	private long acctNo;
	private double balance = 0;
	private static int count = 0;

	/**
	 * Default constructor
	 */
	public StudentAccount() {
		++count;
		acctNo = count;
		balance = 0;
	}
	/**
	 * A constructor for balance
	 * @param balance The amount of money to be put into account
	 */
	public StudentAccount(double balance) {
		++count;
		acctNo = count;
		this.balance = balance;
	}
	/**
	 * A method to get the account number
	 * @return acctNo The account number
	 */
	public long getAcctNo() {
		return acctNo;
	}
	/**
	 * A method to get the balance
	 * @return balance The balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * A method to get the count
	 * @return count The number count is on
	 */
	public int getCounter() {
		return count;
	}
	/**
	 * A method to set the balance
	 * @param balance The balance to be set to
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * A method to deposit
	 * @param amount The amount to be deposited into account
	 */
	public void deposit(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;
		} else {
			System.out.println("Must enter a positive amount");
		}
	}
	/**
	 * A method to charge
	 * @param amount The amount to be charged to an account
	 */
	public void charge(double amount) {
		if (amount > 0) {
			this.balance = balance - amount;
		} else {
			System.out.println("Must enter a positive amount");
		}
	}
	/**
	 * A method to transfer
	 * @param a The account the money is getting transfered to
	 * @param amount The amount to be transfered from one account to another
	 */
	public void transfer(StudentAccount a, double amount) {
		if (amount > 0) {
			this.balance = this.balance - amount;
			a.balance = a.balance + amount;
		}
	}
	/**
	 * A method for printInfo
	 * Prints the account number, with balance
	 */
	public void printInfo () {
		System.out.println("Account number: " + acctNo + '\n' + "Current balance: " + balance);
	}
	/**
	 * A method for toString
	 * Prints the account number, with balance
	 */
	@Override
	public String toString() {
		return "Account number: " + acctNo + '\n' + "Current balance: " + balance;
	}
	/**
	 * A method to compare one account's balance to another
	 * @param a the account to be compared from
	 */
	public int compareTo(StudentAccount a) {
		if (this.balance > a.balance) {
			return 1;
		}
		else if (this.balance == a.balance) {
			return 0;
		}
		else 
			return -1;
	}
}
