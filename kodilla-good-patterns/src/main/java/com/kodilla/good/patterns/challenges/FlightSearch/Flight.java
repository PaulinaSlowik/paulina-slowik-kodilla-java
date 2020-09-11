package com.kodilla.good.patterns.challenges.FlightSearch;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!departureAirport.equals(flight.departureAirport)) return false;
        return arrivalAirport.equals(flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        int result = departureAirport.hashCode();
        result = 31 * result + arrivalAirport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flight opportunities: " +
                "departure airport: '" + departureAirport + '\'' +
                ", arrival airport: '" + arrivalAirport + '\'';
    }
}