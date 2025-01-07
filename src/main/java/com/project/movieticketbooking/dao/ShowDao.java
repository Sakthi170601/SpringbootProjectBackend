package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieticketbooking.entity.Movieshow;
import com.project.movieticketbooking.repository.ShowRepository;

@Repository
public class ShowDao {

	@Autowired
	ShowRepository showRepository;

//	1.save
	public Movieshow saveShow(Movieshow Show) {
		return showRepository.save(Show);
	}

//	2.findById
	public Movieshow findShowById(int id) {
		Optional<Movieshow> optionalShow = showRepository.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Movieshow> findAllShow() {
		return showRepository.findAll();
	}

//	4.update
	public Movieshow updateShow(Movieshow Show, int id) {
		Movieshow findShow = findShowById(id);
		if (findShow != null) {
			Show.setMovieshowid(id);
			return Show;

		}
		return null; // exception will be there if the findShow object is null
	}

//	5.delete
	public Movieshow deleteShow(int id) {
		Movieshow findedShow = findShowById(id);
		if (findedShow != null) {
			showRepository.delete(findedShow);
			return findedShow;
		}
		return null; // exception will be there for object is not present
	}

}
