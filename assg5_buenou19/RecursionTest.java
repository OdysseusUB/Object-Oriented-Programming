/**
 * @author Ulysses Bueno
 * A class for Recursion Test
 */
package assg5_buenou19;

import java.util.Scanner;

public class RecursionTest {

	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		int choice;
		int bIndex;
		int eIndex;
		String userInput;

		/**
		 * A do loop for the user to select options from the menu
		 */
		do {
			printMenu();
			choice = kbd.nextInt();
			kbd.nextLine();
			switch (choice) {

			case 1:
				System.out.println("Type a string: ");
				userInput = kbd.nextLine();
				System.out.println("Enter the beginning index: ");
				bIndex = kbd.nextInt();
				System.out.println(substringRecursive(userInput, bIndex));

				break;

			case 2:
				System.out.println("Type a string: ");
				userInput = kbd.nextLine();
				System.out.println("Enter the beginning index");
				bIndex = kbd.nextInt();
				System.out.println("Enter the end index: ");
				eIndex = kbd.nextInt();
				System.out.println(substringRecursive(userInput, bIndex, eIndex));
				break;

			}

		} while (choice != 3);
		kbd.close();
	}

	/**
	 * A method for substringRecursive
	 * @param str The string to be chopped up
	 * @param beginIndex The index the user wants the new string to start at
	 * @return Will return nothing if the beginning index is the same length as string given. Else, returns the new string beginning where the user requests.
	 */
	public static String substringRecursive(String str, int beginIndex) {
		if (beginIndex == str.length()) {
			return "";
		}
		return str.charAt(beginIndex) + substringRecursive(str, beginIndex + 1);
	}

	/**
	 * A method for substringRecursive
	 * @param str The string to be chopped up
	 * @param beginIndex The index the user wants the new string to start at
	 * @param endIndex The index the user wants the new string to stop at. Will NOT include the end index.
	 * @return Will return nothing if the beginning index is the same length as string given. Else, returns the new string beginning where the user requests and ending where requested.
	 */
	public static String substringRecursive(String str, int beginIndex, int endIndex) {
		if (beginIndex >= endIndex) {
			return "";
		}
		return str.charAt(beginIndex) + substringRecursive(str, beginIndex + 1, endIndex);
	}

	/**
	 * A method for printMenu
	 * Prints the menu
	 */
	private static void printMenu() {
		System.out.println('\n' + "Select an option:" + '\n' + "1. Test two-parameter substringRecursive method " + '\n'
				+ "2. Test three-parameter substringRecursive method" + '\n' + "3. Exit" + '\n');
	}
}
