//@Author - Ulysses Bueno
//A method for DateChange

package assg1_buenou19;

import java.util.*;

public class DateChange {

	public static void main(String[] args) {
		
		String date, month, day, year;
		int sep, sep2;
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("Please enter a date in the form mon/day/year: ");
		date = kbd.nextLine();
		
		sep = date.indexOf('/');
		sep2 = date.lastIndexOf('/');
		
		month = date.substring(0, sep);
		day = date.substring(sep + 1, sep2);
		year = date.substring(sep2 + 1, date.length());
		
		System.out.println("Your date in European form is: "  + day + "." + month + "." + year);
		
		kbd.close();
	}

}
