/**
 * A class for StudentNotFoungException
 * @author - Ulysses Bueno
 */
package assg4_buenou19;

@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {
	/**
	 * Default constructor
	 */
	public StudentNotFoundException() {
		super("Student not found");
	}

	/**
	 * One-parameter constructor
	 * @param msg The given message
	 */
	public StudentNotFoundException(String msg) {
		super(msg);
	}

}
