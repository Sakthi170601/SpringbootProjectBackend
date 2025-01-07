package com.project.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.ShowDao;
import com.project.movieticketbooking.entity.Movieshow;
import com.project.movieticketbooking.exception.ListOfShowNotFoundException;
import com.project.movieticketbooking.exception.ShowNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class ShowService {

	@Autowired
	ShowDao showDao;

//	1.save
	public ResponseEntity<ResponseStructure<Movieshow>> saveShow(Movieshow Show) {
		ResponseStructure<Movieshow> structure = new ResponseStructure<>();
		structure.setData(showDao.saveShow(Show));
		structure.setMessage("Show saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Movieshow>>(structure, HttpStatus.CREATED);
	}

	// 2.findShowById
	public ResponseEntity<ResponseStructure<Movieshow>> findShowById(int id) {
		Movieshow foundedShow = showDao.findShowById(id);
		if (foundedShow != null) {
			ResponseStructure<Movieshow> structure = new ResponseStructure<>();
			structure.setData(foundedShow);
			structure.setMessage("Show Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Movieshow>>(structure, HttpStatus.FOUND);
		}
		throw new ShowNotFoundException("Show Detail Not Found For A Given Id"); // exception will be there
																					// ShowNotFoundException
	}

	// 3.findAll
	public ResponseEntity<ResponseStructure<List<Movieshow>>> findAllShow() {
		List<Movieshow> Show = showDao.findAllShow();
		if (Show != null) {
			ResponseStructure<List<Movieshow>> structure = new ResponseStructure<>();
			structure.setData(Show);
			structure.setMessage("Shows Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Movieshow>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfShowNotFoundException("Show's Details Not Found"); // exception will be there if list of Show is
																			// empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<Movieshow>> updateShow(Movieshow Show, int id) {
		Movieshow updatedShow = showDao.updateShow(Show, id);
		if (updatedShow != null) {
			ResponseStructure<Movieshow> structure = new ResponseStructure<>();
			structure.setData(updatedShow);
			structure.setMessage("Show Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movieshow>>(structure, HttpStatus.OK);
		}
		throw new ShowNotFoundException("Show Not Available For A Given Id"); // exception will be there if object is
																				// not present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Movieshow>> deleteShow(int id) {
		ResponseEntity<ResponseStructure<Movieshow>> foundedShow = findShowById(id);
		if (foundedShow != null) {
			ResponseStructure<Movieshow> structure = new ResponseStructure<>();
			structure.setData(showDao.deleteShow(id));
			structure.setMessage("Show Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movieshow>>(structure, HttpStatus.OK);
		}
		throw new ShowNotFoundException("For A Given Id Show Not Present"); // exception will be there if object is not
																			// present
	}
}
