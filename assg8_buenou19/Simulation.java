/**
 * @author - Ulysses Bueno
 * A class for Simulation
 */
package assg8_buenou19;

import java.io.*;

import java.util.*;

public class Simulation {

	public static void main(String[] args) {

		Scanner inputStream = null;
		int currentTime = 1;

		int peopleCounter = 0;
		double waitingTime = 0;

		Queue<Event> queue = new LinkedList<>();
		EventList eventList = new EventList();

		//Gets file and processes first arrival
		try {
			inputStream = new Scanner(new File("assg8_input.txt"));
			Event event = new Event(inputStream.nextInt(), inputStream.nextInt(), 'A');
			eventList.addEvent(event);
			waitingTime += event.getTransactionTime();

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
		}

		//Simulation begins
		System.out.println("Simulation Begins");

		while (!eventList.isEmpty()) {
			Event newEvent = eventList.list.remove(0);
			currentTime = newEvent.getArrivalTime();

			if (newEvent.eventType == 'A') {
				processArrival(eventList, queue, newEvent, currentTime, inputStream);
				System.out.println("Processing an arrival at time: " + currentTime);
				waitingTime += newEvent.getTransactionTime();
			} else if (newEvent.eventType == 'D') {
				processDeparture(eventList, queue, newEvent, currentTime);
				System.out.println("Processing a departure at time: " + currentTime);
				peopleCounter++;
			}
		}

		waitingTime /= peopleCounter;

		// Prints final statistics
		System.out.println("Simulation Ends");
		System.out.println("\nFinal Statistics: ");
		System.out.println("Total number of people processed: " + peopleCounter);
		System.out.println("Average time of waiting spent: " + waitingTime);

	}

	/**
	 * A method for processArrival
	 * @param eventList The eventList to be used
	 * @param queue The queue representing the line in a bank
	 * @param event The actual event to be processed
	 * @param currentTime The current time at processing
	 * @param inputStream The input
	 */
	public static void processArrival(EventList eventList, Queue<Event> queue, Event event, int currentTime,
			Scanner inputStream) {

		boolean atFront = queue.isEmpty();

		queue.add(event);
		eventList.removeEvent(event);

		if (atFront) {
			Event newEvent = new Event(currentTime + event.getTransactionTime(), 'D');
			eventList.addEvent(newEvent);
		}

		if (inputStream.hasNextLine()) {
			Event addedEvent = new Event(Integer.parseInt(inputStream.next()), Integer.parseInt(inputStream.next()), 'A');
			eventList.addEvent(addedEvent);

		}

	}

	/**
	 * A method for processDeparture
	 * @param eventList The eventList to be used
	 * @param queue The queue representing the line in a bank
	 * @param event The actual event to be processed
	 * @param currentTime The current time at processing
	 */
	public static void processDeparture(EventList eventList, Queue<Event> queue, Event event, int currentTime) {

		if (!queue.isEmpty()) {
			queue.remove();
		}

		eventList.removeEvent(event);

		if (!queue.isEmpty()) {
			Event newEvent = queue.peek();

			Event addedEvent = new Event(newEvent.getTransactionTime() + currentTime, 'D');
			eventList.addEvent(addedEvent);
		}

		currentTime += event.getArrivalTime() + event.getTransactionTime();
	}

}