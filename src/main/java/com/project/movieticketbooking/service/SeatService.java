package com.project.movieticketbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.project.movieticketbooking.dao.SeatDao;
import com.project.movieticketbooking.entity.Seat;
import com.project.movieticketbooking.exception.ListOfSeatNotFoundException;
import com.project.movieticketbooking.exception.SeatNotFoundException;
import com.project.movieticketbooking.util.ResponseStructure;

@Service
public class SeatService {

	@Autowired
	SeatDao seatDao;

//	1.save
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(Seat Seat) {
		ResponseStructure<Seat> structure = new ResponseStructure<>();
		structure.setData(seatDao.saveSeat(Seat));
		structure.setMessage("Seat saved successfull");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Seat>>(structure, HttpStatus.CREATED);
	}

	// 2.findSeatById
	public ResponseEntity<ResponseStructure<Seat>> findSeatById(int id) {
		Seat foundedSeat = seatDao.findSeatById(id);
		if (foundedSeat != null) {
			ResponseStructure<Seat> structure = new ResponseStructure<>();
			structure.setData(foundedSeat);
			structure.setMessage("Seat Founded successfull");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Seat>>(structure, HttpStatus.FOUND);
		}
		throw new SeatNotFoundException("Seat Not Found"); // exception will be there SeatNotFoundException
	}

	// 3.findAll
	public ResponseEntity<ResponseStructure<List<Seat>>> findAllSeat() {
		List<Seat> Seat = seatDao.findAllSeat();
		if (Seat != null) {
			ResponseStructure<List<Seat>> structure = new ResponseStructure<>();
			structure.setData(Seat);
			structure.setMessage("Seats Founded successfully");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Seat>>>(structure, HttpStatus.FOUND);
		}
		throw new ListOfSeatNotFoundException("Seat's Details Not Found"); // exception will be there if list of Seat is
																			// empty
	}

//	4.update

	public ResponseEntity<ResponseStructure<Seat>> updateSeat(Seat Seat, int id) {
		Seat updatedSeat = seatDao.updateSeat(Seat, id);
		if (updatedSeat != null) {
			ResponseStructure<Seat> structure = new ResponseStructure<>();
			structure.setData(updatedSeat);
			structure.setMessage("Seat Updated Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Seat>>(structure, HttpStatus.OK);
		}
		throw new SeatNotFoundException("Seat  Couldn't Present For A Given Id "); // exception will be there if object
																					// is not present

	}

//	5.delete
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(int id) {
		ResponseEntity<ResponseStructure<Seat>> foundedSeat = findSeatById(id);
		if (foundedSeat != null) {
			ResponseStructure<Seat> structure = new ResponseStructure<>();
			structure.setData(seatDao.deleteSeat(id));
			structure.setMessage("Seat Deleted Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Seat>>(structure, HttpStatus.OK);
		}
		throw new SeatNotFoundException("Couldn't Find A Data For A Given Id Can't Delete"); // exception will be there
																								// if object is not
																								// present
	}

}
