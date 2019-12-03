package com.finartz.caseStudy.ticketingSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "TicketSEQ")
	private Long id;
	@ManyToOne
	private Flight flight;
	private Double price;
	private String seatNumber;
	private Long passengerIdNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Long getPassengerIdNumber() {
		return passengerIdNumber;
	}

	public void setPassengerIdNumber(Long passengerIdNumber) {
		this.passengerIdNumber = passengerIdNumber;
	}

}
