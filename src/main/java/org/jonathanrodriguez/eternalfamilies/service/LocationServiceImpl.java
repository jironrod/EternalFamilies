package org.jonathanrodriguez.eternalfamilies.service;

import java.util.List;
import java.util.Optional;

import org.jonathanrodriguez.eternalfamilies.model.Location;
import org.jonathanrodriguez.eternalfamilies.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepo locationRepo;

	@Override
	public List<Location> getAllLocations() {

		return locationRepo.findAll();
	}

	@Override
	public void saveLocation(Location location) {

		this.locationRepo.save(location);
	}

	@Override
	public Location getLocationById(long id) {

		Optional<Location> optional = locationRepo.findById(id);

		Location location = null;

		if (optional.isPresent()) {
			location = optional.get();
		} else {
			throw new RuntimeException("Location not found for id :: " + id);
		}
		return location;
	}

	@Override
	public void deleteLocationById(long id) {

		this.locationRepo.deleteById(id);
	}
}