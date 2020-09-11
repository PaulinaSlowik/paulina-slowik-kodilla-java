package com.kodilla.good.patterns.challenges.FlightSearch;

public class ApplicationFlightSearch {
    public static void main(String[] args) {
        FlightDataBase retriever = new FlightDataBase();

        FlightServiceDeparture departure = new FlightServiceDeparture();
        System.out.println("Flights from Kraków:");
        departure.flightServiceDeparture(retriever.flightDataBase, "Kraków").stream().forEach(System.out::println);

        FlightServiceArrival arrival = new FlightServiceArrival();
        System.out.println("Flights to Kraków:");
        arrival.flightServiceArrival(retriever.flightDataBase, "Kraków").stream().forEach(System.out::println);

        FlightServiceAllConnecting allConnecting = new FlightServiceAllConnecting();
        System.out.println("All connecting flights from Kraków to Warszawa:");
        allConnecting.flightServiceAllConnecting(retriever.flightDataBase, "Kraków","Warszawa","Poznań").stream().forEach(System.out::println);
    }
}