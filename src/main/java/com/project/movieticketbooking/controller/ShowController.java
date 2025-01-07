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
import com.project.movieticketbooking.entity.Movieshow;
import com.project.movieticketbooking.service.ShowService;
import com.project.movieticketbooking.util.ResponseStructure;

@RestController
@RequestMapping("Show")
public class ShowController {

	@Autowired
	ShowService showService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Movieshow>> saveShow(@RequestBody Movieshow Show) {
		return showService.saveShow(Show);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Movieshow>> findBookigById(@RequestParam int id) {
		return showService.findShowById(id);
	}

	@GetMapping("findAllShow")
	public ResponseEntity<ResponseStructure<List<Movieshow>>> findAllShow() {
		return showService.findAllShow();
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Movieshow>> updateShow(@RequestBody Movieshow movieShow,
			@RequestParam int id) {
		return showService.updateShow(movieShow, id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movieshow>> deleteShow(@RequestParam int id) {
		return showService.deleteShow(id);
	}
}
