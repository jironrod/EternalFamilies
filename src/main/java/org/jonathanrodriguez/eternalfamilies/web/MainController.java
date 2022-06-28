package org.jonathanrodriguez.eternalfamilies.web;

import org.jonathanrodriguez.eternalfamilies.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return"index";
	}
	
	@GetMapping("/events")
	public String viewHomePage(Model model) {

		model.addAttribute("listEvents", eventService.getAllEvents());

		return "events";
	}
}
