/**
 *@Author - Ulysses Bueno
 */
package assg3_buenou19;

public class RewardsAccount extends StudentAccount {

	private double rewards;
	/**
	 * Default constructor for Rewards Account
	 */
	public RewardsAccount() {
		super();
		rewards = 0;
	}
	/**
	 * Constructor for Rewards Account
	 * @param balance The amount of money to be in account
	 */
	public RewardsAccount(double balance) {
		super(balance);
		if (balance >= 100) {
			rewards = balance / 25;
		}
	}
	/**
	 * A method to get rewards amount
	 * @return rewards The value of rewards
	 */
	public double getRewards() {
		return rewards;
	}
	/**
	 * A method to redeem rewards
	 */
	public void redeemRewards() {
		if (this.rewards >= 20) {
			double balance = getBalance();
			setBalance(rewards + balance);
			this.rewards = 0;
		}
		else {
			System.out.println("Insuffiecient reward funds");
		}
	}
	/**
	 * A method to print the account number, with balance, and rewards if applicable
	 */
	@Override
	public String toString() {
		return "Account number: " + getAcctNo() + '\n' + "Current balance: " + getBalance() + 
				'\n' + "Rewards balance: " + getRewards();
	}
	/**
	 * A method to deposit into account
	 * @param amount The amount to be deposited into account
	 */
	@Override
	public void deposit(double amount) {
		if(amount >= 100) {
			this.rewards = amount / 25;
			double balance = getBalance();
			setBalance(balance + amount);
		}
		else if (amount > 0) {
			double balance = getBalance();
			setBalance(balance + amount);
		}
		else {
		System.out.println("Must enter a positive amount");
		}
	}
	/**
	* A method for printInfo
	* This method gets the account number, balance, and rewards if applicable
	*/
	@Override
	public void printInfo() {
		System.out.println("Account number: " + getAcctNo() + '\n' + "Current balance: " + getBalance() + 
				'\n' + "Rewards balance: " + getRewards());
	}
	
	
}
