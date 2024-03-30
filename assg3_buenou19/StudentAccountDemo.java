/**
 *@Author - Ulysses Bueno
 */
package assg3_buenou19;

public class StudentAccountDemo {

	public static void main(String[] args) {
		
	
	StudentAccount s1 = new StudentAccount();
	StudentAccount s2 = new StudentAccount(2000);
	StudentAccount s3 = new StudentAccount(500);
	
	s1.printInfo();
	s2.printInfo();
	s3.printInfo();
	System.out.print('\n');
	
	
	System.out.println("There are a total of: " + s1.getCounter() + " accounts" + '\n');
	
	System.out.println("Accout 2's information is: ");
	System.out.println(s2.getAcctNo());
	System.out.println(s2.getBalance());
	
	System.out.print('\n');
	s1.setBalance(8439);
	s1.printInfo();
	
	System.out.println('\n' + "Add $5000 to account 3: ");
	s3.deposit(5000);
	s3.printInfo();
	
	System.out.println('\n' + "Charge $5000 to account 3: ");
	s3.charge(5000);
	s3.printInfo();
	
	System.out.println('\n' + "Transfer $200 from account 2 to account 3: ");
	s2.transfer(s3, 200);
	System.out.println("s2's new balance is: " + s2.getBalance());
	System.out.println("s3's new balance is: " + s3.getBalance());
	
	System.out.print('\n');
	System.out.println(s1.toString());
	System.out.println(s2.toString());
	System.out.println(s3.toString());

	System.out.println('\n' + "The account's balance compared to each other:");
	System.out.println(s1.compareTo(s2));
	System.out.println(s3.compareTo(s3));
	System.out.println(s3.compareTo(s2));
	
	System.out.println("***Rewards***");
	
	RewardsAccount r1 = new RewardsAccount();
	RewardsAccount r2 = new RewardsAccount(100);
	RewardsAccount r3 = new RewardsAccount(800);
	
	System.out.println(r1.toString());
	System.out.println(r2.toString());
	System.out.println(r3.toString());
	
	System.out.println('\n' + "Redeem rewards for accounts r2 and r3:");
	System.out.print("r2: "); 
	r2.redeemRewards();
	r3.redeemRewards();
	
	System.out.println('\n' + "r3's current rewards balance after redeeming is: " + r3.getRewards() + '\n');
	System.out.println(r3.toString());
	
	System.out.print('\n');
	
	System.out.println("Deposit $50 into r1, $100 into accounts r2, and $0 into r3: ");
	r1.deposit(50);
	r2.deposit(100);
	
	r1.printInfo();
	r2.printInfo();
	
	r3.deposit(0);
	r3.printInfo();
	}
}
