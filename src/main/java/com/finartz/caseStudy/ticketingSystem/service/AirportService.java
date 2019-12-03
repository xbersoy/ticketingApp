package com.finartz.caseStudy.ticketingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.caseStudy.ticketingSystem.model.Airport;
import com.finartz.caseStudy.ticketingSystem.repository.AirportRepository;

@Service
public class AirportService {
	@Autowired
	private AirportRepository airportRepository;

	public Airport getById(Long id) {
		return airportRepository.findById(id).get();
	}

	public Airport save(Airport airport) {
		return airportRepository.save(airport);
	}

	public void deleteById(Long id) {
		airportRepository.deleteById(id);
	}
}
