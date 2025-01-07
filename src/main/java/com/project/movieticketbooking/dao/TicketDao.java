package com.project.movieticketbooking.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.movieticketbooking.entity.Ticket;
import com.project.movieticketbooking.repository.TicketRepository;

@Repository
public class TicketDao {

	@Autowired
	TicketRepository ticketRepository;
	
//	1.save
	public Ticket saveTicket(Ticket Ticket) {
		return ticketRepository.save(Ticket);
	}

//	2.findById
	public Ticket findTicketById(int id) {
		Optional<Ticket> optionalTicket = ticketRepository.findById(id);
		if (optionalTicket.isPresent()) {
			return optionalTicket.get();
		}
		return null; // exception will be there if the id is not present
	}

//	3.Find All
	public List<Ticket> findAllTicket() {
		return ticketRepository.findAll();
	}

//	4.update
	public Ticket updateTicket(Ticket Ticket, int id) {
		Ticket findTicket = findTicketById(id);
		if (findTicket != null) {
			Ticket.setTicketId(id);
			return Ticket;

		}
		return null; // exception will be there if the findTicket object is null
	}

//	5.delete
	public Ticket deleteTicket(int id) {
		Ticket findedTicket = findTicketById(id);
		if (findedTicket != null) {
			ticketRepository.delete(findedTicket);
			return findedTicket;
		}
		return null; // exception will be there for object is not present
	}

}
