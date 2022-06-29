package org.jonathanrodriguez.eternalfamilies.repository;

import java.util.Optional;

import org.jonathanrodriguez.eternalfamilies.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
	
	// part of JUnit testing
	Optional<Event> findByEventName(String eventName);

}
