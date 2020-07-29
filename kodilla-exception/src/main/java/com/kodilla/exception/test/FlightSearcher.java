package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        HashMap<String, Boolean > mapOfAirport =  new HashMap<>();
        mapOfAirport.put("BER",true);
        mapOfAirport.put("LON",false);
        mapOfAirport.put("WAW",true);
        mapOfAirport.put("ROM",false);
        mapOfAirport.put("PAR",true);
        mapOfAirport.put("BAR",false);

        for (Map.Entry<String, Boolean> entry : mapOfAirport.entrySet()) {
            if (flight.getDepartureAirport() == entry.getKey()) {
                System.out.println("This flight is avaible");
            } else {
                throw new RouteNotFoundException("This airport is not support. Please try different one");
            }
        }
    }
}
