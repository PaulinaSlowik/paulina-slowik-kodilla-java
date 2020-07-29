package com.kodilla.exception.test;

import java.nio.channels.FileLockInterruptionException;

public class FindFlight {
    public static void main(String[] args) {
        Flight berlinLondon = new Flight("BER","LON");

        FlightSearcher flightSearcher = new FlightSearcher();

        try {
            flightSearcher.findFlight(berlinLondon);
        }catch (RouteNotFoundException e){
            System.out.println("That airport not exist! Programme is still working.");
        } finally {
            System.out.println("Choose another destination.");
        }
    }
}
