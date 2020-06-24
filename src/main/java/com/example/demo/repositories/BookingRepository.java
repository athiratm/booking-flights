package com.example.demo.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Flight;

@Repository
public interface BookingRepository extends JpaRepository<Booking, BigInteger>{

	@Query("from Booking where bookingId=:bookingId")
	Optional<Flight> findById(@Param("bookingId")String bookingId);
}
