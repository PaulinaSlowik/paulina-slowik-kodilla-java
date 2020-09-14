package com.kodilla.good.patterns.challenges.FlightSearch;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightServiceAllConnecting {
    Set<Flight> flightServiceAllConnecting(Set<Flight> flightDataBase, String flightFrom, String flightTo, String flightVia) {
        Set<Flight> flightServiceFromToVia = flightDataBase.stream()
                .filter(flight -> flight.getDepartureAirport().equals(flightFrom))
                .filter(flight -> flight.getArrivalAirport().equals(flightVia))
                .collect(Collectors.toSet());
        Set<Flight> flightServiceViaToTo = flightDataBase.stream()
                .filter(flight -> flight.getDepartureAirport().equals(flightVia))
                .filter(flight -> flight.getArrivalAirport().equals(flightTo))
                .collect(Collectors.toSet());
        Set<Flight> flightsConnect = new HashSet<>();
        flightsConnect.addAll(flightServiceFromToVia);
        flightsConnect.addAll(flightServiceViaToTo);
        return  flightsConnect;
    }
}