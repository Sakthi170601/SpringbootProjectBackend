package com.project.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.movieticketbooking.entity.Location;
import com.project.movieticketbooking.service.LocationService;
import com.project.movieticketbooking.util.ResponseStructure;

@RestController
@RequestMapping("Location")
public class LocationController {

	@Autowired
	LocationService locationService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Location>> saveLocation(@RequestBody Location location) {
		return locationService.saveLocation(location);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Location>> findBookigById(@RequestParam int id) {
		return locationService.findLocationById(id);
	}

	@GetMapping("findAllLocation")
	public ResponseEntity<ResponseStructure<List<Location>>> findAllLocation() {
		return locationService.findAllLocation();
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Location>> updateLocation(@RequestBody Location Location,
			@RequestParam int id) {
		return locationService.updateLocation(Location, id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Location>> deleteLocation(@RequestParam int id) {
		return locationService.deleteLocation(id);
	}

}
