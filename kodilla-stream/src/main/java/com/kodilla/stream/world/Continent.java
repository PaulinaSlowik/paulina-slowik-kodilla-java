package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final String continentName;
    private final List<Country> listOfCountry = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public void addListOfCountry(Country country){
        listOfCountry.add(country);
    }

    public boolean removeListOfCountry(Country country){
        return listOfCountry.remove(country);
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Country> getListOfCountry() {
        return listOfCountry;
    }
}
