package com.finartz.caseStudy.ticketingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.caseStudy.ticketingSystem.model.Flight;
import com.finartz.caseStudy.ticketingSystem.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	
	public Flight getById( Long id )
	{
		return flightRepository.findById( id )
								.get();
	}
	
	public Flight save( Flight flight )
	{
		flight.setTotalSeat(100);
		flight.setAvailableSeat(100);
		return flightRepository.save( flight );
	}

	public void deleteById( Long id )
	{
		flightRepository.deleteById( id );
	}

}
