package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Flight;
import com.example.demo.entity.SearchCriteria;
import com.example.demo.service.FlightService;


@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "*")
public class FlightController {

	@Autowired(required = true)
	private FlightService flightService;

	@PostMapping("/addFlight")
	public void addFlight(@RequestBody Flight flight) {
		try {
			flightService.addFlight(flight);
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	@PostMapping("/getFlights")
	public List<Flight> getFlightsForSelectedCriteria(@RequestBody SearchCriteria searchCriteria) {
		try {
			List<Flight> flights = flightService.getFlightsForSelectedCriteria(searchCriteria);
			return flights;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	//	return null;
		
		
	}
	

}
