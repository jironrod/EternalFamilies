package org.jonathanrodriguez.eternalfamilies.service;

import java.util.List;

import org.jonathanrodriguez.eternalfamilies.model.Location;

public interface LocationService {

	List<Location> getAllLocations();

	void saveLocation(Location location);

	Location getLocationById(long id);
	
	void deleteLocationById(long id);
}
