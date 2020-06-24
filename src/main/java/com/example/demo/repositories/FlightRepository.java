package com.example.demo.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	@Query("from Flight where flightNumber=:flightNumber")
	Optional<Flight> findByFlightNumber(@Param("flightNumber")String flightNumber);
	
	List<Flight> findByDepartureAirport(String departureAirport);
	
	List<Flight> findByDepartureAirportAndArrivalAirportAndDepartureDate(String departureAirport,
			String arrivalAirport,Date departureDate);
}
