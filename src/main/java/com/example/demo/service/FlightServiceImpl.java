package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Flight;
import com.example.demo.entity.SearchCriteria;
import com.example.demo.repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;

	@Override
	public ResponseEntity<Flight> addFlight(Flight flight) {
		Optional<Flight> findById = flightRepository.findByFlightNumber(flight.getFlightNumber());
		try {
			if (!findById.isPresent()) {
				flightRepository.save(flight);
				return new ResponseEntity<Flight>(flight, HttpStatus.OK);
			} /*
				 * else throw new RecordAlreadyPresentException("Flight with number: " +
				 * flight.getFlightNo() + " already present");
				 */
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return null;
	}

	@Override
	public List<Flight> getFlightsForSelectedCriteria(SearchCriteria searchCriteria) {

		try {
			List<Flight> flights = flightRepository.findByDepartureAirportAndArrivalAirportAndDepartureDate(searchCriteria.getDepartureAirport(),
					searchCriteria.getArrivalAirport(), searchCriteria.getDepartureDate());
			return flights;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
