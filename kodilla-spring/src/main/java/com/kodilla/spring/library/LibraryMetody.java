package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
//wstrzykiwanie zależności poprzez metody
public class LibraryMetody {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    //Autowired to sygnał dla Springa aby użyć tej metody do wstrzyknięcia zależności
    @Autowired
    public void setLibraryDbController(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
