package com.finartz.caseStudy.ticketingSystem.controller;

import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.FLIGHTS;
import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.PATH_ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.caseStudy.ticketingSystem.model.Flight;
import com.finartz.caseStudy.ticketingSystem.service.FlightService;

@RestController
@RequestMapping(FLIGHTS)
public class FlightController {

	@Autowired
	private FlightService flightService;

	@GetMapping(PATH_ID)
	public Flight getById(@PathVariable Long id) {
		return flightService.getById(id);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public Flight save(@RequestBody Flight flight) {
		return flightService.save(flight);
	}

	@DeleteMapping(PATH_ID)
	public void deleteById(@PathVariable Long id) {
		flightService.deleteById(id);
	}

}
