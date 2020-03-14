package com.pluralsight.bddfundamentals.airport;

import java.util.*;

public abstract class Flight {

	private String id;
	Set<Passenger> passengersList = new HashSet<Passenger>();

	public Flight(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Set<Passenger> getPassengerSet() {
		return Collections.unmodifiableSet(passengersList);
	}

	public abstract boolean addPassenger(Passenger passenger);

	public abstract boolean removePassenger(Passenger passenger);

}
