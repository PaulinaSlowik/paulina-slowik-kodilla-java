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

        for(Map.Entry<String, Boolean> entry :mapOfAirport.entrySet()){
            if (entry.getKey() != null) {
                System.out.println(mapOfAirport);
            } else {
                throw new RouteNotFoundException("Airport doesn't exist!");
            }
        }
    }
}
