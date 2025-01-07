package com.project.movieticketbooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.LocationDao;
import com.project.movieticketbooking.entity.Location;
import com.project.movieticketbooking.exception.ListOfLocationNotFoundException;
import com.project.movieticketbooking.exception.LocationNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class LocationService {

	@Autowired
	LocationDao locationDao;

//	1.save
	public ResponseEntity<ResponseStructure<Location>> saveLocation(Location location) {
		ResponseStructure<Location> structure = new ResponseStructure<>();
		structure.setData(locationDao.saveLocation(location));
		structure.setMessage("Location saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Location>>(structure, HttpStatus.CREATED);
	}

	// 2.findLocationById
	public ResponseEntity<ResponseStructure<Location>> findLocationById(int id) {
		Location foundedLocation = locationDao.findLocationById(id);
		if (foundedLocation != null) {
			ResponseStructure<Location> structure = new ResponseStructure<>();
			structure.setData(foundedLocation);
			structure.setMessage("Location Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Location>>(structure, HttpStatus.FOUND);
		}
		throw new LocationNotFoundException("For A Given Id Location Not Found"); // exception will be there
																					// locationNotFoundException
	}

	// 3.findAll
	public ResponseEntity<ResponseStructure<List<Location>>> findAllLocation() {
		List<Location> location = locationDao.findAllLocation();
		if (location != null) {
			ResponseStructure<List<Location>> structure = new ResponseStructure<>();
			structure.setData(location);
			structure.setMessage("Locations Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Location>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfLocationNotFoundException("Location Details Not Found"); // exception will be there if list of
																					// location is empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<Location>> updateLocation(Location Location, int id) {
		Location updatedLocation = locationDao.updateLocation(Location, id);
		if (updatedLocation != null) {
			ResponseStructure<Location> structure = new ResponseStructure<>();
			structure.setData(updatedLocation);
			structure.setMessage("Location Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Location>>(structure, HttpStatus.OK);
		}
		throw new LocationNotFoundException("For A Given Id Location Is Not Present"); // exception will be there if
																						// object is not present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Location>> deleteLocation(int id) {
		ResponseEntity<ResponseStructure<Location>> foundedLocation = findLocationById(id);
		if (foundedLocation != null) {
			ResponseStructure<Location> structure = new ResponseStructure<>();
			structure.setData(locationDao.deleteLocation(id));
			structure.setMessage("Location Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Location>>(structure, HttpStatus.OK);
		}
		throw new LocationNotFoundException("Location Not Present For A Given Id"); // exception will be there if object
																					// is not present
	}

}
