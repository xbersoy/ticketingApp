package com.finartz.caseStudy.ticketingSystem.controller;

import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.AIRPORTS;
import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.PATH_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.caseStudy.ticketingSystem.model.Airport;
import com.finartz.caseStudy.ticketingSystem.service.AirportService;

@RestController
@RequestMapping(AIRPORTS)
public class AirportController {

	@Autowired
	private AirportService airportService;

	@GetMapping(PATH_ID)
	public Airport getById(@PathVariable Long id) {
		return airportService.getById(id);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public Airport save(@RequestBody Airport airport) {
		return airportService.save(airport);
	}

	@DeleteMapping(PATH_ID)
	public void deleteById(@PathVariable Long id) {
		airportService.deleteById(id);
	}

}
