package com.finartz.caseStudy.ticketingSystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.finartz.caseStudy.ticketingSystem.model.Flight;

public interface FlightRepository  extends CrudRepository<Flight, Long>{
	
	/*@Query( "SELECT F FROM Flight F WHERE LOWER(F.flightCode) = LOWER(:flightCode)" )
	List<Flight> findByFlightCode( @Param( "flightCode" ) String flightCode );*/


}
