package org.jonathanrodriguez.eternalfamilies.web;

import org.jonathanrodriguez.eternalfamilies.model.Event;
import org.jonathanrodriguez.eternalfamilies.model.Location;
import org.jonathanrodriguez.eternalfamilies.service.EventService;
import org.jonathanrodriguez.eternalfamilies.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/locationtForm")
	public String showNewEventForm(Model model) {

		// create model attribute to bind form data
		Location location = new Location();
		model.addAttribute("location", location);

		return "new_location";
	}

	@PostMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location location) {

		// save location to database
		locationService.saveLocation(location);

		return "redirect:/locations";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get location from the service
		Location location = locationService.getLocationById(id);

		// set location as a model attribute to auto populate the form
		model.addAttribute("location", location);

		return "update_location";
	}

	@GetMapping("deleteLocation/{id}")
	public String deleteLocation(@PathVariable(value = "id") long id) {

		// call delete location method
		this.locationService.deleteLocationById(id);

		return "redirect:/locations";
	}
}