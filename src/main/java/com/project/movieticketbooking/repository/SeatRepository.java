package com.project.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movieticketbooking.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
