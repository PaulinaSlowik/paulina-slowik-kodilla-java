package com.kodilla.good.patterns.challenges.FlightSearch;

import java.util.HashSet;
import java.util.Set;

public class FlightDataBase {
    Set<Flight> flightDataBase = new HashSet<>();

    public FlightDataBase() {
        flightDataBase.add(new Flight("Kraków", "Poznań"));
        flightDataBase.add(new Flight("Poznań", "Warszawa"));
        flightDataBase.add(new Flight("Wrocław", "Katowice"));
        flightDataBase.add(new Flight("Warszawa", "Poznań"));
        flightDataBase.add(new Flight("Wrocław", "Gdańsk"));
        flightDataBase.add(new Flight("Gdańsk", "Wrocław"));
        flightDataBase.add(new Flight("Katowice", "Wrocław"));
        flightDataBase.add(new Flight("Poznań", "Kraków"));
        flightDataBase.add(new Flight("Kraków", "Wrocław"));
        flightDataBase.add(new Flight("Gdańsk", "Kraków"));
    }
}
