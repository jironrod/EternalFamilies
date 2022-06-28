package org.jonathanrodriguez.eternalfamilies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_location")
	private String eventLocation;

	@Column(name = "event_description")
	private String eventDescription;

	public Event() {

	}
	
	public Event(long id, String eventName, String eventLocation, String eventDescription) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.eventDescription = eventDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
}