package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieticketbooking.entity.Movie;
import com.project.movieticketbooking.repository.MovieRepository;

@Repository
public class MovieDao {

	@Autowired
	MovieRepository movieRepository;
	
//	1.save
	public Movie saveMovie(Movie Movie) {
		return movieRepository.save(Movie);
	}

//	2.findById
	public Movie findMovieById(int id) {
		Optional<Movie> optionalMovie = movieRepository.findById(id);
		if (optionalMovie.isPresent()) {
			return optionalMovie.get();
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Movie> findAllMovie() {
		return movieRepository.findAll();
	}

//	4.update
	public Movie updateMovie(Movie Movie, int id) {
		Movie findMovie = findMovieById(id);
		if (findMovie != null) {
			Movie.setMovieId(id);
			return Movie;

		}
		return null; // exception will be there if the findMovie object is null
	}

//	5.delete
	public Movie deleteMovie(int id) {
		Movie findedMovie = findMovieById(id);
		if (findedMovie != null) {
			movieRepository.delete(findedMovie);
			return findedMovie;
		}
		return null; // exception will be there for object is not present
	}

}
