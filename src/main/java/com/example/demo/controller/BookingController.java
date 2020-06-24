package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "*")
public class BookingController {
	
	@Autowired(required = true)
	private BookingService bookingService;

	
	@PostMapping("/createBooking")
	public void addFlight(@RequestBody Booking booking) {
		try {
			bookingService.createBooking(booking);
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

}
