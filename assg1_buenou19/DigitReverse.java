//@Author - Ulysses Bueno
//A class for DigitReverse

package assg1_buenou19;

import java.util.*;

public class DigitReverse {
	
	public static void main(String[] args) {
	
		int input = 0;
		
		System.out.println("Please enter a non-negative integer (-1 to exit):");
		Scanner kbd = new Scanner(System.in);
		input = kbd.nextInt();
		
		while (input != -1) {
			System.out.println("Your number printed in reverse order is:");
			digitExtract(input);
			
			System.out.println("Please enter a non-negative integer (-1 to exit):");
			input = kbd.nextInt();
			}
		
		kbd.close();
		
	}
	//A method to print the digits in reverse
	//@param digit The whole int to be separated and printed out in reverse
	public static void digitExtract(int digit) {
		
		while (digit > 0) {
			int num = digit % 10;
			digit = digit /10;
			
			System.out.println(num);
		}
	}
}