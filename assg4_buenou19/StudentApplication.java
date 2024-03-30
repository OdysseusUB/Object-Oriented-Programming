/**
 * A class for StudentApplication
 * @author - Ulysses Bueno
 */
package assg4_buenou19;

import java.io.*;
import java.util.Scanner;

public class StudentApplication {

	public static void main(String[] args) {

		Scanner kbd = new Scanner(System.in);
		String filename = "assg4_input.txt";
		Scanner inputStream = null;
		String line;
		int choice;
		int count = 0;
		Student[] students;

		/**
		 * An array to store all of the students (Student)
		 */
		students = new Student[100];

		/**
		 * Open the input file and store the information in the "students" array
		 */
		try {
			inputStream = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Error openning the file " + filename);
			System.exit(1);
		}

		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			String temp[] = line.split(",");

			if (temp.length == 5) {
				students[count] = new Student(temp[0], temp[1], temp[2].charAt(0), temp[3], temp[4]);
				count++;
			} else {
				students[count] = new Student(temp[0], temp[1], temp[2].charAt(0), temp[3]);
				count++;
			}

		}

		/**
		 * Displaying the list of students and menu
		 * Allows user to select an option off menu and method will execute
		 */
		printList(students, count);
		System.out.println(count + " students total.");
		
		do {
			printMenu();
			choice = kbd.nextInt();
			kbd.nextLine();
			switch (choice) {

			case 1:
				System.out.println("Enter id of student to search for: ");
				try {
					int n;
					String in = kbd.nextLine();
					n = Student.StudentSearchById(students, count, in);
					System.out.println(students[n]);
				} catch (StudentNotFoundException e1) {
					System.out.print(e1);
				}

				break;

			case 2:
				System.out.println("Enter name of student to search for: ");
				try {
					int n;
					String in = kbd.nextLine();
					n = Student.StudentSearchByName(students, count, in);
					System.out.println(students[n]);
				} catch (StudentNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("Enter id of the student to change major: ");
				try {
					int n;
					String major = kbd.nextLine();
					n = Student.StudentSearchById(students, count, major);
					System.out.println("Enter new major");
					students[n].setMajor(kbd.nextLine());
				} catch (StudentNotFoundException e1) {
					System.out.print(e1);
				}

			case 4:
                System.out.println("Thank you!");
                break;
			}

		}

		while (choice != 4);
		kbd.close();
	}
/**
 * A method to print the menu
 */
	private static void printMenu() {
		System.out.println('\n' + "Select an option:" + '\n' + "1. Search student by id" + '\n' + "2. Search student by name"
				+ '\n' + "3. Change student major" + '\n' + "4. Exit");
	}
/**
 * A method to print the list of students
 * @param students The array of Student's
 * @param count The amount of students
 */
	public static void printList(Student[] students, int count) {
		for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
	}
}
