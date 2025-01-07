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

import com.project.movieticketbooking.entity.Movie;
import com.project.movieticketbooking.service.MovieService;
import com.project.movieticketbooking.util.ResponseStructure;

@RestController
@RequestMapping("Movie")
public class MovieController {

	@Autowired
	MovieService movieService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Movie>> findBookigById(@RequestParam int id) {
		return movieService.findMovieById(id);
	}

	@GetMapping("findAllMovie")
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovie() {
		return movieService.findAllMovie();
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Movie>> updateMovie(@RequestBody Movie Movie, @RequestParam int id) {
		return movieService.updateMovie(Movie, id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(@RequestParam int id) {
		return movieService.deleteMovie(id);
	}
}
