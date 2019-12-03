package com.finartz.caseStudy.ticketingSystem.controller;

import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.PATH_ID;
import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.TICKETS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.caseStudy.ticketingSystem.model.Ticket;
import com.finartz.caseStudy.ticketingSystem.service.FlightService;
import com.finartz.caseStudy.ticketingSystem.service.TicketService;

@RestController
@RequestMapping(TICKETS)
public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	private FlightService flightService;

	@GetMapping(PATH_ID)
	public ResponseEntity<Ticket> getById(@PathVariable Long id) throws Exception {
		try {

		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ticketService.getById(id), HttpStatus.OK);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<Ticket> save(@RequestBody Ticket ticket) throws Exception {
		try {
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(ticketService.save(ticket), HttpStatus.OK);
	}

	@DeleteMapping(PATH_ID)
	public void deleteById(@PathVariable Long id) {
		ticketService.deleteById(id);
	}

}
