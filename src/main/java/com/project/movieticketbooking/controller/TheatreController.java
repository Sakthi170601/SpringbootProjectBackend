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

import com.project.movieticketbooking.entity.Theatre;
import com.project.movieticketbooking.service.TheatreService;
import com.project.movieticketbooking.util.ResponseStructure;

@RestController
@RequestMapping("Theatre")
public class TheatreController {
	@Autowired
	TheatreService theatreService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestBody Theatre Theatre) {
		return theatreService.saveTheatre(Theatre);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Theatre>> findBookigById(@RequestParam int id) {
		return theatreService.findTheatreById(id);
	}

	@GetMapping("findAllTheatre")
	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatre() {
		return theatreService.findAllTheatre();
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(@RequestBody Theatre Theatre,
			@RequestParam int id) {
		return theatreService.updateTheatre(Theatre, id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(@RequestParam int id) {
		return theatreService.deleteTheatre(id);
	}
}
