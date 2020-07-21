package com.kodilla.stream;

import com.kodilla.stream.book.BookDirectory;

public class StreamMainTeoria7_3OnlyForEach {
    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        //tworzenie strumienia Stream dla kolekcji zwracanej przez metodę getList() klasy BookDirectory
        //a następnie na tym strumieniu wywołuje operację filtrującą, wybierającą jedynie te książki, których rok wydania jest większy niż 2005.
        //Na końcu kolektor strumienia wyświetla obiekty książek na ekranie konsoli:
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);
    }
}

