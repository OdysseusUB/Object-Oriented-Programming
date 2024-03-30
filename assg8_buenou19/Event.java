/**
 * @author - Ulysses Bueno
 * A class for Event
 */
package assg8_buenou19;

/*
 * A class for Event
 */
public class Event implements Comparable<Event>{
	
	int arrivalTime;
	int transactionTime;
	char eventType;
	
	/**
	 * A default constructor for Event
	 */
	public Event() {
		arrivalTime = 0;
		transactionTime = 0;
		eventType = ' ';
	}
	
	/**
	 * A constructor for Event
	 * @param arrTime The arrival time
	 * @param transTime The transaction time
	 */
	public Event(int arrTime, int transTime) {
		arrivalTime = arrTime;
		transactionTime = transTime;
		eventType = 'A';
	}
	
	/**
	 * A constructor for Event
	 * @param transTime The transaction time
	 * @param type The event type
	 */
	public Event(int transTime, char type) {
		arrivalTime = transTime;
		eventType = type;
	}
	
	/**
	 * A constructor for Event 
	 * @param arrTime The arrival time
	 * @param transTime The transaction time
	 * @param type The type of event
	 */
	public Event(int arrTime, int transTime, char type) {
		arrivalTime = arrTime;
		transactionTime = transTime;
		eventType = type;
	}
	
	/**
	 * A method for getArrivalTime
	 * return arrivalTime The arrival time
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * A method for getTransactionTime
	 * return transactionTime The transaction time
	 */
	public int getTransactionTime() {
		return transactionTime;
	}
	
	/**
	 * A method for getEventType
	 * return eventType The event type
	 */
	public char getEventType() {
		return eventType;
	}
	
	/**
	 * A method for toString
	 * return The string
	 */
	@Override
	public String toString() {
		if(this.eventType == 'A') {
			return "The event is: " + this.getEventType() + ", " + this.getArrivalTime() + ", " + this.getTransactionTime();
		}
		else
			return "The event is: " + this.getEventType() + ", " + this.getArrivalTime();
	}

	/**
	 * A method for compareTo
	 * Returns different integers based of if the event is before or after a different event
	 */
	@Override
	public int compareTo(Event a) {
		if (this.arrivalTime < a.arrivalTime) {
			return -1;
		}
		else if (a.arrivalTime < this.arrivalTime) {
			return 1;
		}
		else if (a.eventType == 'D') {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	
}
