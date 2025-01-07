package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieticketbooking.entity.Booking;
import com.project.movieticketbooking.repository.BookingRepository;

@Repository
public class BookingDao {

	@Autowired
	BookingRepository bookingRepository;

//	1.save
	public Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

//	2.findById
	public Booking findBookingById(int id) {
		Optional<Booking> optionalBooking = bookingRepository.findById(id);
		if (optionalBooking.isPresent()) {
			return optionalBooking.get();
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Booking> findAllBooking() {
		return bookingRepository.findAll();
	}

//	4.update
	public Booking updateBooking(Booking booking, int id) {
		Booking findBooking = findBookingById(id);
		if (findBooking != null) {
			booking.setBookingId(id);
			return booking;

		}
		return null; // exception will be there if the findBooking object is null
	}

//	5.delete
	public Booking deleteBooking(int id) {
		Booking findedBooking = findBookingById(id);
		if (findedBooking != null) {
			bookingRepository.delete(findedBooking);
			return findedBooking;
		}
		return null; // exception will be there for object is not present
	}
	
	

}
