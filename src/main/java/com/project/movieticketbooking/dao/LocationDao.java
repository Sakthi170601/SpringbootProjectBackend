package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieticketbooking.entity.Location;
import com.project.movieticketbooking.repository.LocationRepository;

@Repository
public class LocationDao {

	@Autowired
	LocationRepository locationRepository;
	
//	1.save
	public Location saveLocation(Location Location) {
		return locationRepository.save(Location);
	}

//	2.findById
	public Location findLocationById(int id) {
		Optional<Location> optionalLocation = locationRepository.findById(id);
		if (optionalLocation.isPresent()) {
			return optionalLocation.get();
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Location> findAllLocation() {
		return locationRepository.findAll();
	}

//	4.update
	public Location updateLocation(Location Location, int id) {
		Location findLocation = findLocationById(id);
		if (findLocation != null) {
			Location.setLocationId(id);
			return Location;

		}
		return null; // exception will be there if the finLocation object is null
	}

//	5.delete
	public Location deleteLocation(int id) {
		Location findedLocation = findLocationById(id);
		if (findedLocation != null) {
			locationRepository.delete(findedLocation);
			return findedLocation;
		}
		return null; // exception will be there for object is not present
	}

}
