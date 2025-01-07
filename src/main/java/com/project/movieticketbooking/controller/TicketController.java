package com.project.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.movieticketbooking.entity.Ticket;
import com.project.movieticketbooking.service.TicketService;
import com.project.movieticketbooking.util.ResponseStructure;

@RestController
@RequestMapping("Ticket")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestBody Ticket Ticket) {
		return ticketService.saveTicket(Ticket);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Ticket>> findBookigById(@RequestParam int id) {
		return ticketService.findTicketById(id);
	}

	@GetMapping("findAllTicket")
	public ResponseEntity<ResponseStructure<List<Ticket>>> findAllTicket() {
		return ticketService.findAllTicket();
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(@RequestBody Ticket Ticket, @RequestParam int id) {
		return ticketService.updateTicket(Ticket, id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(@RequestParam int id) {
		return ticketService.deleteTicket(id);
	}
}
