package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Flight;
import com.example.demo.entity.SearchCriteria;

public interface FlightService {
	
	public ResponseEntity<?> addFlight(Flight flight);
	
	//public List<Flight> getAllFlights();
	
	public List<Flight> getFlightsForSelectedCriteria(SearchCriteria searchCriteria);

}
