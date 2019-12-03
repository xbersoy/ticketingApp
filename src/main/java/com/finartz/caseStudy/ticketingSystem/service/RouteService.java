package com.finartz.caseStudy.ticketingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.caseStudy.ticketingSystem.model.Route;
import com.finartz.caseStudy.ticketingSystem.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository routeRepository;

	public Route getById(Long id) {
		return routeRepository.findById(id).get();
	}

	public Route save(Route route) {
		return routeRepository.save(route);
	}

	public void deleteById(Long id) {
		routeRepository.deleteById(id);
	}
}
