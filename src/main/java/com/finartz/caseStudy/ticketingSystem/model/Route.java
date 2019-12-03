package com.finartz.caseStudy.ticketingSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RouteSEQ")
	private Long id;
	@ManyToOne
	private Airport airportTo;
	@ManyToOne
	private Airport airportFrom;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Airport getAirportFrom() {
		return airportFrom;
	}
	public void setAirportFrom(Airport airportFrom) {
		this.airportFrom = airportFrom;
	}
	public Airport getAirportTo() {
		return airportTo;
	}
	public void setAirportTo(Airport airportTo) {
		this.airportTo = airportTo;
	}

}
