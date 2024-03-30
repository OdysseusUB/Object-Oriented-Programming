/**
 * @author Ulysses Bueno
 * A class for PhoneBook
 */
package assg9_buenou19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBook {

	BinarySearchTree<Person, String> book = new BinarySearchTree<Person, String>();
	TreeIterator<Person> iTree = new TreeIterator<Person>(book);

	/**
	 * A method for addPerson
	 * 
	 * @param name   The name for new person
	 * @param number The number for new person
	 */
	public void addPerson(String name, String number) {
		if (searchPerson(name) != null) {
			System.out.println("Person already exists.");
			return;
		} else {
			Person newPerson = new Person(name, number);
			book.insert(newPerson);
		}
	}

	/**
	 * A method for deletePerson
	 * 
	 * @param name The name of person to delete
	 */
	public void deletePerson(String name) {
		if (book.retrieve(name) == null) {
			System.out.println("Person was not found.");
		} else {
			Person person = book.retrieve(name);
			book.delete(person);
			System.out.println("Deleted!");
		}
	}

	/**
	 * A method for searchPerson
	 * 
	 * @param name The name of person to search for
	 * @return book.retrieve(name) The name of person in search of
	 */
	public Person searchPerson(String name) {
		if (book.retrieve(name) != null) {
			return book.retrieve(name);
		} else {
			return null;
		}
	}

	/**
	 * A method for updatePerson
	 * 
	 * @param name   The name of person to update
	 * @param number The new number of person being updated
	 */
	public void updatePerson(String name, String number) {
		Person person = searchPerson(name);
		if (person != null) {
			person.number = number;
		} else {
			System.out.println("Person does not exist.");
		}
	}

	/**
	 * A method for displayPhoneBook
	 */
	public void displayPhoneBook() {
		iTree.setInorder();

		while (iTree.hasNext()) {
			System.out.println(iTree.next());
		}
	}

	/**
	 * A method for save
	 * 
	 * @param fileName The name of file to be saved to
	 */
	public void Save(String fileName) {
		Person person;
		iTree.setInorder();

		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
		} catch (IOException ex) {
			System.out.println("File not found");
		}
		while (iTree.hasNext()) {
			person = (Person) iTree.next();
			writer.println(person.getName() + "\t" + person.getPhoneNumber());
		}
		writer.close();
	}

	/**
	 * A method for loadData
	 * 
	 * @param fileName The name of file to be loaded
	 */
	public void loadData(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String str[] = line.split("\t");

				Person person = new Person(str[0], str[1]);

				book.insert(person);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
