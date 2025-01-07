package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieticketbooking.entity.Seat;
import com.project.movieticketbooking.repository.SeatRepository;

@Repository
public class SeatDao {

	@Autowired
	SeatRepository seatRepository;
	
//	1.save
	public Seat saveSeat(Seat Seat) {
		return seatRepository.save(Seat);
	}

//	2.findById
	public Seat findSeatById(int id) {
		Optional<Seat> optionalSeat = seatRepository.findById(id);
		if (optionalSeat.isPresent()) {
			return optionalSeat.get();
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Seat> findAllSeat() {
		return seatRepository.findAll();
	}

//	4.update
	public Seat updateSeat(Seat Seat, int id) {
		Seat findSeat = findSeatById(id);
		if (findSeat != null) {
			Seat.setSeatId(id);
			return Seat;

		}
		return null; // exception will be there if the findSeat object is null
	}

//	5.delete
	public Seat deleteSeat(int id) {
		Seat findedSeat = findSeatById(id);
		if (findedSeat != null) {
			seatRepository.delete(findedSeat);
			return findedSeat;
		}
		return null; // exception will be there for object is not present
	}
	
	
	
}
