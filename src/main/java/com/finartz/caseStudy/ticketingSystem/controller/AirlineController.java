package com.finartz.caseStudy.ticketingSystem.controller;

import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.AIRLINES;
import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.PATH_ID;

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

import com.finartz.caseStudy.ticketingSystem.model.Airline;
import com.finartz.caseStudy.ticketingSystem.service.AirlineService;

@RestController
@RequestMapping(AIRLINES)
public class AirlineController {

	@Autowired
	private AirlineService airlineService;

	@GetMapping(PATH_ID)
	public ResponseEntity<Airline> getById(@PathVariable Long id) throws Exception {
		try {
			return new ResponseEntity<>(airlineService.getById(id), HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public Airline save(@RequestBody Airline airline) {
		return airlineService.save(airline);
	}

	@DeleteMapping(PATH_ID)
	public void deleteById(@PathVariable Long id) {
		airlineService.deleteById(id);
	}


}
