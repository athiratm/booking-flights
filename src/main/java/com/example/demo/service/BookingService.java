package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Booking;

public interface BookingService {

	public ResponseEntity<?> createBooking(Booking newBooking);
}
