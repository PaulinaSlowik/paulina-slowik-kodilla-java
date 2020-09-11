package com.kodilla.good.patterns.challenges.FlightSearch;

import java.util.Set;
import java.util.stream.Collectors;

public class FlightServiceArrival {
    Set<Flight> flightServiceArrival (Set<Flight> flightDataBase, String flightTo){
        return flightDataBase.stream()
                .filter(flight -> flight.getArrivalAirport().equals(flightTo))
                .collect(Collectors.toSet());
    }
}
