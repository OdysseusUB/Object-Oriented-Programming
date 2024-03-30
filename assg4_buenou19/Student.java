/**
 * A class for Student
 * @author - Ulysses Bueno
 */
package assg4_buenou19;

public class Student {

	private String id;
	private String name;
	private char gender;
	private String dob;
	private String major;
	
	/**
	 * Constructor with given id, name, gender, date of birth, and major
	 * @param id The given id
	 * @param name The given name
	 * @param gender The given gender
	 * @param dob The given date of birth
	 * @param major The given major
	 */
	public Student(String id, String name, char gender, String dob, String major) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.major = major;
	}
	
	/**
	 * Constructor with given id, name, gender, and date of birth
	 * @param id The given id
	 * @param name The given name
	 * @param gender The given gender
	 * @param dob The given date of birth
	 */
	public Student(String id, String name, char gender, String dob) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.major = "undeclared";
	}
	
	/**
	 * A method to get the id
	 * @return The id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * A method to get the name
	 * @return The name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A method to get the gender
	 * @return The gender
	 */
	public char getGender() {
		return gender;
	}
	
	/**
	 * A method to get the date of birth
	 * @return The date of birth
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * A method to get the major
	 * @return The major
	 */
	public String getMajor() {
		return major;
	}
	
	/**
	 * A method to set the major
	 * @param major The major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * A method for to string
	 */
	public String toString() {
		return id + ", " + name + ", " + gender + ", " + dob + ", " + major;
	}
	
	/**
	 * A method to search for a student by name
	 * @param students The array of students to search within
	 * @param length How long the array is
	 * @param name The name of student user is searching for
	 * @return The index of where the student is located in the array
	 * @throws StudentNotFoundException The exception to throw if student was not found
	 */
	public static int StudentSearchByName(Student[] students, int length, String name) throws StudentNotFoundException {
		for (int i = 0; i < length; i++) {
            if (students[i].getName().equals(name)) {
                return i;
            }
        }
		 throw new StudentNotFoundException("Student not found");
	}
	
	/**
	 * A method to search for a student by id
	 * @param students The array of students to search within
	 * @param length How long the array is
	 * @param id The id of student user is searching for
	 * @return The index of where the student is located in the array
	 * @throws StudentNotFoundException The exception to throw if student was not found
	 */
	public static int StudentSearchById(Student[] students, int length, String id) throws StudentNotFoundException{
		for (int i = 0; i < length; i++) {
            if (students[i].getId().equals(id)) {
                return i;
            }
        }
		 throw new StudentNotFoundException("Student not found");
	}
	
	
}
