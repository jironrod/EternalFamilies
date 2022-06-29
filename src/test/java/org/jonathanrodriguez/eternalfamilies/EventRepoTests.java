package org.jonathanrodriguez.eternalfamilies;

import org.jonathanrodriguez.eternalfamilies.model.Event;
import org.jonathanrodriguez.eternalfamilies.repository.EventRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventRepoTests {

	@Autowired
	private EventRepo eventRepo;

	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveEventTest() {

		// unable to implement builder dot notation
		// -- IntelliJ-specific???
		// attempted to follow along with Java Guides YouTube video "CRUD JUnit Tests
		// for Spring Data JPA | Testing Repository Layer | Spring Boot | @DataJpaTest"
		Event event = Event.builder()
				.eventName("Independence Missouri Temple Open House")
				.eventLocation("Independence Missouri Temple")
				.eventDescription("Have the opportunity to publicly tour this wonderful temple of the Church of Jesus Christ of Latter-day Saaints!")
				.build();

		eventRepo.save(event);

		Assertions.assertThat(event.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void getEventTest() {

		Event event = eventRepo.findById(1L).get();

		Assertions.assertThat(event.getId()).isEqualTo(1L);
	}

	@Test
	@Order(3)
	public void getListofEventsTest() {

		List<Event> events = eventRepo.findAll();

		Assertions.assertThat(events.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateEventTest() {

		Event event = eventRepo.findById(1L).get();

		event.setEventName("Charlie's Angels");

		Event eventUpdated = eventRepo.save(event);

		Assertions.assertThat(eventUpdated.getEventName()).isEqualTo("Charlie's Angels");
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteEventTest() {

		Event event = eventRepo.findById(1L).get();

		eventRepo.delete(event);

		Event event1 = null;

		Optional<Event> optionalEvent = eventRepo.findByEventName("Charlie's Angels");

		if (optionalEvent.isPresent()) {
			event1 = optionalEvent.get();
		}

		Assertions.assertThat(event1).isNull();
	}
}
