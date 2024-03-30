//@Author - Ulysses Bueno
// A class for CountGrades

package assg1_buenou19;

import java.util.*;

public class CountGrades {

	public static void main(String[] args) {

		int numOfGrades;
		int total = 0;
		int sum = 0;

		Scanner kbd = new Scanner(System.in);
		System.out.println("Enter the number of grades: (0 or less to exit)");
		numOfGrades = kbd.nextInt();

		if (numOfGrades <= 0) {
			System.out.println("Goodbye!");
			System.exit(0);
		}

		int[] grades = new int[numOfGrades];

		for (int i = 0; i < numOfGrades; i++) {
			System.out.println("Enter a grade: ");
			grades[i] = kbd.nextInt();
		}

		int length = grades.length;

		for (int i = 0; i < grades.length; i++) {
			sum += grades[i];
		}

		double average = sum / length;
		System.out.println("The average grade is : " + average);
		System.out.println("The grades above average are:");
		
		//This for loop finds the total amount of grades above the average grade
		for (int i = 0; i < numOfGrades; i++) {
			if (average < grades[i]) {
				System.out.println((grades[i]));
				total = total + 1;
			}
		}

		System.out.println("for a total of " + total + " grades");

		kbd.close();
	}

}
