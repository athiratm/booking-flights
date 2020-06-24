package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

public class SearchCriteria {

	private String departureAirport;
	private String arrivalAirport;
	private Date departureDate;
	private Timestamp DepartureTime;
	private int paxCount;

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Timestamp getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		DepartureTime = departureTime;
	}

	public int getPaxCount() {
		return paxCount;
	}

	public void setPaxCount(int paxCount) {
		this.paxCount = paxCount;
	}

}
