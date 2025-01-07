package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieticketbooking.entity.Theatre;
import com.project.movieticketbooking.repository.TheatreRepository;

@Repository
public class TheatreDao {

	@Autowired
	TheatreRepository theatreRepository;
	
//	1.save
	public Theatre saveTheatre(Theatre Theatre) {
		return theatreRepository.save(Theatre);
	}

//	2.findById
	public Theatre findTheatreById(int id) {
		Optional<Theatre> optionalTheatre = theatreRepository.findById(id);
		if (optionalTheatre.isPresent()) {
			return optionalTheatre.get();
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Theatre> findAllTheatre() {
		return theatreRepository.findAll();
	}

//	4.update
	public Theatre updateTheatre(Theatre Theatre, int id) {
		Theatre findTheatre = findTheatreById(id);
		if (findTheatre != null) {
			Theatre.setTheatreId(id);
			return Theatre;

		}
		return null; // exception will be there if the findTheatre object is null
	}

//	5.delete
	public Theatre deleteTheatre(int id) {
		Theatre findedTheatre = findTheatreById(id);
		if (findedTheatre != null) {
			theatreRepository.delete(findedTheatre);
			return findedTheatre;
		}
		return null; // exception will be there for object is not present
	}

}
