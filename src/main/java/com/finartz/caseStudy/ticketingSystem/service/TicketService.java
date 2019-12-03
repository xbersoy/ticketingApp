package com.finartz.caseStudy.ticketingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.caseStudy.ticketingSystem.model.Flight;
import com.finartz.caseStudy.ticketingSystem.model.Ticket;
import com.finartz.caseStudy.ticketingSystem.repository.FlightRepository;
import com.finartz.caseStudy.ticketingSystem.repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private FlightRepository flightRepository;

	public Ticket getById(Long id) {
		return ticketRepository.findById(id).get();
	}

	public Ticket save(Ticket ticket) throws Exception {

		try {
			checkAvailableSeats(ticket);

			setTicketProperties(ticket);

			return ticketRepository.save(ticket);
			
		} catch (Exception e) {
			throw e;
		}

	}

	private void setTicketProperties(Ticket ticket) {

		int avaliableSeats = (int) (flightRepository.findById(ticket.getFlight().getId()).get().getAvailableSeat());

		Flight flight = new Flight();
		flight = flightRepository.findById(ticket.getFlight().getId()).get();
		flight.setAvailableSeat(avaliableSeats - 1);

		flightRepository.save(flight);

		ticket.setPrice((double) (100 + 10 * ((100 - avaliableSeats) / 10)));
		ticket.setFlight(flight);
	}

	private void checkAvailableSeats(Ticket ticket) throws Exception {

		Flight flight = new Flight();
		flight = flightRepository.findById(ticket.getFlight().getId()).get();

		if (flight.getAvailableSeat() <= 0)
			throw new Exception("No available seats.");

	}

	public void deleteById(Long id) {
		
		Ticket ticket = new Ticket();
		ticket = ticketRepository.findById(id).get();
		
		int avaliableSeats = (int) (flightRepository.findById(ticket.getFlight().getId()).get().getAvailableSeat());

		Flight flight = new Flight();
		flight = flightRepository.findById(ticket.getFlight().getId()).get();
		flight.setAvailableSeat(avaliableSeats + 1);

		flightRepository.save(flight);
		ticketRepository.deleteById(id);
	}
}
