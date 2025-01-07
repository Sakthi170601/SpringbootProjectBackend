package com.project.movieticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movieticketbooking.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
