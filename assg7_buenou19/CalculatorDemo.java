/**
 * A class for Calculator Demo
 * @author Ulysses Bueno
 */
package assg7_buenou19;

import java.util.Scanner;

public class CalculatorDemo {

	public static void main(String[] args) {

		String input = "";
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter an expression");

		// To check and see if input is "stop"
		while (!input.equalsIgnoreCase("stop")) {
			input = keyboard.nextLine();
			if (input.equalsIgnoreCase("stop")) {
				break;
			}

			Calculator obj = new Calculator(input);

			System.out.println("Infix Expression: " + obj.toString());
			System.out.println("Postfix Expression: " + obj.getPostfix());
			System.out.println("Result: " + obj.evaluate());
			System.out.print("Enter STOP to exit: ");

		}
		System.out.println("Thank you!");
		System.exit(0);

		keyboard.close();
	}

}