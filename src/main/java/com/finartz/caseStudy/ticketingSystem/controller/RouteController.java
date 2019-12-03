package com.finartz.caseStudy.ticketingSystem.controller;

import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.PATH_ID;
import static com.finartz.caseStudy.ticketingSystem.controller.config.Paths.ROUTES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.caseStudy.ticketingSystem.model.Route;
import com.finartz.caseStudy.ticketingSystem.service.RouteService;

@RestController
@RequestMapping(ROUTES)
public class RouteController {
	
	@Autowired
	private RouteService routeService;

	@GetMapping(PATH_ID)
	public Route getById(@PathVariable Long id) {
		return routeService.getById(id);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public Route save(@RequestBody Route route) {
		return routeService.save(route);
	}

	@DeleteMapping(PATH_ID)
	public void deleteById(@PathVariable Long id) {
		routeService.deleteById(id);
	}

}
