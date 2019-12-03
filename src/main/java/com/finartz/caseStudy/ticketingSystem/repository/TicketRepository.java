package com.finartz.caseStudy.ticketingSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.finartz.caseStudy.ticketingSystem.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

	
}
