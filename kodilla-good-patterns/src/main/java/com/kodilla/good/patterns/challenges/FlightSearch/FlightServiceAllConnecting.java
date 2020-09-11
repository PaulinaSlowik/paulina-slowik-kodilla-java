package com.kodilla.good.patterns.challenges.FlightSearch;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightServiceAllConnecting {
    Set<Flight> flightServiceAllConnecting(Set<Flight> flightDataBase, String flightFrom, String flightTo, String flightVia) {
        Set<Flight> flightsFrom = flightDataBase.stream()
                .filter(flight -> flight.getDepartureAirport().equals(flightFrom))
                .collect(Collectors.toSet());
        Set<Flight> flightsTo = flightDataBase.stream()
                .filter(flight -> flight.getArrivalAirport().equals(flightTo))
                .collect(Collectors.toSet());
        Set<Flight> flightsConnect = new HashSet<>();
        flightsConnect.addAll(flightsFrom);
        flightsConnect.addAll(flightsTo);
        flightsConnect.stream().filter(connect -> connect.getDepartureAirport().equals(flightVia));
        return flightsConnect;
    }
}
