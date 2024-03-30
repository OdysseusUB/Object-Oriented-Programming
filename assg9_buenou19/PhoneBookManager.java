/**
 * @author Ulysses Bueno
 * A class for PhoneBookManager
 */
package assg9_buenou19;

import java.io.IOException;
import java.util.Scanner;

public class PhoneBookManager {

	public static void main(String[] args) throws IOException {

		Scanner kbd = new Scanner(System.in);
		String name;
		String number;
		String userInput;
		int choice = 0;
		
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.loadData("assg9_input.txt");
		
		//A while loop that prints menu and contains the user program
		while (choice != 7) {
			System.out.println("1. Add a contact\n" + "2. Delete a contact\n" + "3. Search name of person\n"
					+ "4. Update phone number\n" + "5. Display phone book\n" + "6. Save and Exit\n");

			choice = kbd.nextInt();
			kbd.nextLine();

			
			switch (choice) {
			case 1:
				System.out.println("Enter the name of new contact:");
				name = kbd.nextLine();
				if (phoneBook.searchPerson(name) != null) {
					System.out.println("Person already exists.");
					System.out.println("Press enter to continue: ");
					userInput = kbd.nextLine();
					if (userInput.equals("")) {
						break;
						}
						else {
							System.exit(0);
						}
				}
				System.out.println("Enter the phone number of new contact");
				number = kbd.nextLine();
				phoneBook.addPerson(name, number);
				System.out.println("Press enter to continue: ");
				userInput = kbd.nextLine();
				if (userInput.equals("")) {
				break;
				}
				else {
					System.exit(0);
				}

			case 2:
				System.out.println("Enter name of contact to delete: ");
				name = kbd.nextLine();
				phoneBook.deletePerson(name);
				
				System.out.println("Press enter to continue: ");
				userInput = kbd.nextLine();
				if (userInput.equals("")) {
				break;
				}
				else {
					System.exit(0);
				}


			case 3:
				System.out.println("Enter name of person to search for: ");
				name = kbd.nextLine();
				Person person = phoneBook.searchPerson(name);
				if (person == null) {
					System.out.println("Person does not exist.");
				} else {
					System.out.println(phoneBook.searchPerson(name));
				}
				System.out.println("Press enter to continue: ");
				userInput = kbd.nextLine();
				if (userInput.equals("")) {
				break;
				}
				else {
					System.exit(0);
				}

				

			case 4:
				System.out.println("Enter name of person you'd like to update: ");
				name = kbd.nextLine();
				System.out.println("Enter new phone number: ");
				number = kbd.nextLine();
				phoneBook.updatePerson(name, number);
				System.out.println("Press enter to continue: ");
				userInput = kbd.nextLine();
				if (userInput.equals("")) {
				break;
				}
				else {
					System.exit(0);
				}


			case 5:
				phoneBook.displayPhoneBook();
				
				System.out.println("Press enter to continue: ");
				userInput = kbd.nextLine();
				if (userInput.equals("")) {
				break;
				}
				else {
					System.exit(0);
				}

				
			case 6: 
				phoneBook.Save("assg9_input.txt");
				System.out.println("Saved!");
				System.exit(0);
				break;
			}
		}
		kbd.close();
		System.exit(0);

	}
}