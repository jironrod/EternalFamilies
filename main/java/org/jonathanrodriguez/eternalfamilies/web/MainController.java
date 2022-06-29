package org.jonathanrodriguez.eternalfamilies.web;

import org.jonathanrodriguez.eternalfamilies.service.EventService;
import org.jonathanrodriguez.eternalfamilies.service.LocationService;
import org.jonathanrodriguez.eternalfamilies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private EventService eventService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}

	// @GetMapping("/photos")

	@GetMapping("/events")
	public String viewEvents(Model model) {

		model.addAttribute("listEvents", eventService.getAllEvents());

		return "events";
	}

	@GetMapping("/locations")
	public String viewLocations(Model model) {

		model.addAttribute("listLocations", locationService.getAllLocations());

		return "locations";
	}

	@GetMapping("/community")
	public String viewCommunity(Model model) {

		model.addAttribute("listUsers", userService.getAllUsers());

		return "community";
	}
}
