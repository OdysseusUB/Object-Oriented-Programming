/**
 * @author Ulysses Bueno
 * A class for Person
 */
package assg9_buenou19;

public class Person extends KeyedItem<String> {

	String number;

	/**
	 * Default constructor for Person
	 * 
	 * @param name   The name
	 * @param number The number
	 */
	public Person(String name, String number) {
		super(name);
		this.number = number;
	}

	/**
	 * A method for getName
	 * 
	 * @return getKey() The name
	 */
	public String getName() {
		return getKey();
	}

	/**
	 * A method for getPhoneNumber
	 * 
	 * @return number The number
	 */
	public String getPhoneNumber() {
		return number;
	}

	/**
	 * A method for setNumber
	 * 
	 * @param number The new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * A method for toString
	 */
	@Override
	public String toString() {
		return this.getKey() + "\t" + number;
	}
}
