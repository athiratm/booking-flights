package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Flight;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.FlightRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	FlightRepository flightRepository;

	@Override
	public ResponseEntity<?> createBooking(Booking newBooking) {
		//Optional<Booking> findBookingById = bookingRepository.findById(newBooking.getBookingId());
		
		Optional<Flight> selectedFlightOptional = flightRepository.findByFlightNumber(newBooking.getFlightNumber());
		Flight selectedFlight = selectedFlightOptional.get();
		try {
			if (selectedFlight.getSeats()>newBooking.getPaxCount()) {
				bookingRepository.save(newBooking);
				int paxcount = newBooking.getPaxCount();
				boolean isSeatUpdated = updateSeat(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			}
				
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	private boolean updateSeat(Booking booking) {
		boolean isUpdated = Boolean.FALSE;
		Optional<Flight> bookedFlightOptional = flightRepository.findByFlightNumber(booking.getFlightNumber());
		int remainingSeats = 0;
		if(bookedFlightOptional.isPresent()) {
			Flight bookedFlight = bookedFlightOptional.get();
			remainingSeats = bookedFlight.getSeats() - booking.getPaxCount();
			bookedFlight.setSeats(remainingSeats);
			flightRepository.save(bookedFlight);
		}
		return isUpdated;
	}
}
