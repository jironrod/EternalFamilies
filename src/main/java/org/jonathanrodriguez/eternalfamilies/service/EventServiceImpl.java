package org.jonathanrodriguez.eternalfamilies.service;

import java.util.List;
import java.util.Optional;

import org.jonathanrodriguez.eternalfamilies.model.Event;
import org.jonathanrodriguez.eternalfamilies.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepo eventRepo;

	@Override
	public List<Event> getAllEvents() {

		return eventRepo.findAll();
	}

	@Override
	public void saveEvent(Event event) {

		this.eventRepo.save(event);
	}

	@Override
	public Event getEventById(long id) {

		Optional<Event> optional = eventRepo.findById(id);

		Event event = null;

		if (optional.isPresent()) {
			event = optional.get();
		} else {
			throw new RuntimeException("Event not found for id :: " + id);
		}
		return event;
	}

	@Override
	public void deleteEventById(long id) {

		this.eventRepo.deleteById(id);
	}
}