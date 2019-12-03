package com.finartz.caseStudy.ticketingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.caseStudy.ticketingSystem.model.Airline;
import com.finartz.caseStudy.ticketingSystem.repository.AirlineRepository;

@Service
public class AirlineService {
	@Autowired
	private AirlineRepository airlineRepository;

	public Airline getById(Long id) {
		return airlineRepository.findById(id).get();
	}

	public Airline save(Airline airline) {
		return airlineRepository.save(airline);
	}

	public void deleteById(Long id) {
		airlineRepository.deleteById(id);
	}

}
