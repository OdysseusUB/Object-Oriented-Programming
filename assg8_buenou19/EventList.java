/**
 * @author - Ulysses Bueno
 * A class for EventList
 */
package assg8_buenou19;

import java.util.ArrayList;
import java.util.List;

public class EventList {

	List<Event> list = new ArrayList<Event>();

	/**
	 * Constructor for a new eventList
	 */
	public EventList() {
		this.list = new ArrayList<Event>();
	}

	/**
	 * A method for isEmpty
	 * @return true if the list is empty
	 * @return false if the list is not empty
	 */
	public boolean isEmpty() {
		return this.list.size() == 0;
	}

	/**
	 * A method for addEvent
	 * @param event The event to be added
	 */
	public void addEvent(Event event) {
		if (list.isEmpty()) {
			list.add(event);
		} else {
			boolean added = false;
			for (int i = 0; i < list.size(); i++) {
				Event currentEvent = list.get(i);
				if (event.arrivalTime < currentEvent.arrivalTime) {
					list.add(i, event);
					added = true;
					break;
				} else if (event.arrivalTime == currentEvent.arrivalTime) {
					if (event.eventType == 'A' && currentEvent.eventType == 'D') {
						list.add(i, event);
						added = true;
						break;
					} else if (event.eventType == 'D' && currentEvent.eventType == 'A') {
						added = true;
						break;
					}
				} else if (i == list.size() - 1) {
					list.add(event);
					added = true;
				}
			}
			if (!added) {
				list.add(event);
			}
		}
	}

	/**
	 * A method for removeEvent
	 * @param event The event that is to be deleted from the list
	 */
	public void removeEvent(Event event) {
		list.remove(event);
	}

	/**
	 * A method for getEvent
	 * @param event The event that is to be retrieved from the list
	 * @return The event that is being looked for in the list
	 */
	public Event getEvent(Event event) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == event) {
				return list.get(i);
			}
		}
		return null;
	}
}