package com.project.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.ScreenDao;
import com.project.movieticketbooking.dto.ScreenDto;
import com.project.movieticketbooking.entity.Screen;
import com.project.movieticketbooking.exception.ListOfScreenNotFoundException;
import com.project.movieticketbooking.exception.ScreenNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class ScreenService {

	@Autowired
	ScreenDao screenDao;

//	1.save
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(ScreenDto Screen) {
		
		ResponseStructure<Screen> structure = new ResponseStructure<>();
		structure.setData(screenDao.saveScreen(Screen));
		structure.setMessage("Screen saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Screen>>(structure, HttpStatus.CREATED);
	}

	// 2.findScreenById
	public ResponseEntity<ResponseStructure<Screen>> findScreenById(int id) {
		Screen foundedScreen = screenDao.findScreenById(id);
		if (foundedScreen != null) {
			ResponseStructure<Screen> structure = new ResponseStructure<>();
			structure.setData(foundedScreen);
			structure.setMessage("Screen Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Screen>>(structure, HttpStatus.FOUND);
		}
		throw new ScreenNotFoundException("Screen Data Not Found For A Given Id"); // exception will be there
																					// ScreenNotFoundException
	}

	// 3.findAll
	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreen() {
		List<Screen> Screen = screenDao.findAllScreen();
		if (Screen != null) {
			ResponseStructure<List<Screen>> structure = new ResponseStructure<>();
			structure.setData(Screen);
			structure.setMessage("Screens Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Screen>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfScreenNotFoundException("Screen's Details Not Found"); // exception will be there if list of
																				// Screen is empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<Screen>> updateScreen(Screen Screen, int id) {
		Screen updatedScreen = screenDao.updateScreen(Screen, id);
		if (updatedScreen != null) {
			ResponseStructure<Screen> structure = new ResponseStructure<>();
			structure.setData(updatedScreen);
			structure.setMessage("Screen Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Screen>>(structure, HttpStatus.OK);
		}
		throw new ScreenNotFoundException("Screen Not Found For A Given Id"); // exception will be there if object is
																				// not present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(int id) {
		ResponseEntity<ResponseStructure<Screen>> foundedScreen = findScreenById(id);
		if (foundedScreen != null) {
			ResponseStructure<Screen> structure = new ResponseStructure<>();
			structure.setData(screenDao.deleteScreen(id));
			structure.setMessage("Screen Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Screen>>(structure, HttpStatus.OK);
		}
		throw new ScreenNotFoundException("Couldn't Find A Screen Data For A Given Id"); // exception will be there if
																							// object is not present
	}
}
