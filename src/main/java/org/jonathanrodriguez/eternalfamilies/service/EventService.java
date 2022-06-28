package org.jonathanrodriguez.eternalfamilies.service;

import java.util.List;

import org.jonathanrodriguez.eternalfamilies.model.Event;
import org.springframework.stereotype.Service;

@Service
public interface EventService {

	List<Event> getAllEvents();

	void saveEvent(Event event);

	Event getEventById(long id);
	
	void deleteEventById(long id);
}