package com.project.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movieticketbooking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
