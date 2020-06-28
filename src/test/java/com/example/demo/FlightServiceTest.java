package com.example.demo;

import com.example.demo.entity.Flight;
import com.example.demo.entity.SearchCriteria;
import com.example.demo.repositories.FlightRepository;
import com.example.demo.service.FlightServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {

    @Mock
    FlightRepository flightRepository;

    @InjectMocks
    FlightServiceImpl flightService;


    @Test
    public void testGeFlights() {

        long now = System.currentTimeMillis();
        Time sqlTime = new Time(now);
        Flight flight1 = new Flight();
        flight1.setArrivalAirport("JED");
        flight1.setDepartureAirport("DXB");
        flight1.setFlightNumber("SV05");
        flight1.setDepartureDate(new Date());
        flight1.setDepartureTime(sqlTime);

        SearchCriteria criteria = new SearchCriteria();
        criteria.setArrivalAirport("JED");
        criteria.setDepartureAirport("DXB");

        criteria.setDepartureDate(new Date());

        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        when(flightRepository.findByDepartureAirport("JED")).thenReturn(flightList);
        when(flightService.getFlightsForSelectedCriteria(criteria)).thenReturn(flightList);

        List<Flight> flights = flightRepository.findByDepartureAirport("JED");
        List<Flight> searchResults = flightService.getFlightsForSelectedCriteria(criteria);
        assert(!flights.isEmpty());
        assert(!searchResults.isEmpty());
    }
}
