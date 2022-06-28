package org.jonathanrodriguez.eternalfamilies.web;

import org.jonathanrodriguez.eternalfamilies.model.Event;
import org.jonathanrodriguez.eternalfamilies.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/eventForm")
	public String showNewEventForm(Model model) {

		// create model attribute to bind form data
		Event event = new Event();
		model.addAttribute("event", event);

		return "new_event";
	}

	@PostMapping("/saveEvent")
	public String saveEvent(@ModelAttribute("event") Event event) {

		// save event to database
		eventService.saveEvent(event);

		return "redirect:/events";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get event from the service
		Event event = eventService.getEventById(id);

		// set event as a model attribute to auto populate the form
		model.addAttribute("event", event);

		return "update_event";
	}

	@GetMapping("deleteEvent/{id}")
	public String deleteEvent(@PathVariable(value = "id") long id) {

		// call delete event method
		this.eventService.deleteEventById(id);

		return "redirect:/events";
	}
}