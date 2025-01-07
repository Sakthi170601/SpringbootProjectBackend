package com.project.movieticketbooking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.MovieDao;
import com.project.movieticketbooking.entity.Movie;
import com.project.movieticketbooking.exception.ListOfMoviesNotFoundException;
import com.project.movieticketbooking.exception.MovieNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class MovieService {

	@Autowired
	MovieDao movieDao;

//	1.save
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie Movie) {
		ResponseStructure<Movie> structure = new ResponseStructure<>();
		structure.setData(movieDao.saveMovie(Movie));
		structure.setMessage("Movie saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.CREATED);
	}

	// 2.findMovieById
	public ResponseEntity<ResponseStructure<Movie>> findMovieById(int id) {
		Movie foundedMovie = movieDao.findMovieById(id);
		if (foundedMovie != null) {
			ResponseStructure<Movie> structure = new ResponseStructure<>();
			structure.setData(foundedMovie);
			structure.setMessage("Movie Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.FOUND);
		}
		throw new MovieNotFoundException("Movie Not Present For A Given Id"); // exception will be there
																				// MovieNotFoundException
	}

	// 3.findAll
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovie() {
		List<Movie> Movie = movieDao.findAllMovie();
		if (Movie != null) {
			ResponseStructure<List<Movie>> structure = new ResponseStructure<>();
			structure.setData(Movie);
			structure.setMessage("Movies Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Movie>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfMoviesNotFoundException("Movie's Details Not Found"); // exception will be there if list of
																				// Movie is empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<Movie>> updateMovie(Movie Movie, int id) {
		Movie updatedMovie = movieDao.updateMovie(Movie, id);
		if (updatedMovie != null) {
			ResponseStructure<Movie> structure = new ResponseStructure<>();
			structure.setData(updatedMovie);
			structure.setMessage("Movie Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.OK);
		}
		throw new MovieNotFoundException("For A Given Id Movie Not Found"); // exception will be there if object is not
																			// present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(int id) {
		ResponseEntity<ResponseStructure<Movie>> foundedMovie = findMovieById(id);
		if (foundedMovie != null) {
			ResponseStructure<Movie> structure = new ResponseStructure<>();
			structure.setData(movieDao.deleteMovie(id));
			structure.setMessage("Movie Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movie>>(structure, HttpStatus.OK);
		}
		throw new MovieNotFoundException("For Given Id Data Is Not Present So You Can't Able To Delete"); // exception
																											// will be
																											// there if
																											// object is
																											// not
																											// present
	}

}
