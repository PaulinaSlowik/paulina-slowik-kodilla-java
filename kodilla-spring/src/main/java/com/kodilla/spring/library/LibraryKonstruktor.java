package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
//wstrzykiwanie zależności przez konstruktor
public class LibraryKonstruktor {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    //inicjowanie pola libraryDbController poprzez konstruktor klasy
    //Spring zauważył że do konstruktora klasy Library trzeba podać jako argument obiekt klasy LibraryDbController
    //Spring utworzył najpierw Bean klasy LibraryDbController a potem wstrzyknął go do konstruktora Beana klasy Library
    @Autowired
    public LibraryKonstruktor(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }
    public LibraryKonstruktor() {
        //do nothing
    }
    public void saveToDb() {
        libraryDbController.saveData();
    }
    public void loadFromDb() {
        libraryDbController.loadData();
    }
}