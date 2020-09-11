package com.kodilla.good.patterns.challenges.FlightSearch;

import java.util.Set;
import java.util.stream.Collectors;

public class FlightServiceDeparture {
    Set<Flight> flightServiceDeparture(Set<Flight> flightDataBase, String flightFrom) {
        return flightDataBase.stream()
                .filter(flight -> flight.getDepartureAirport().equals(flightFrom))
                .collect(Collectors.toSet());
    }
}