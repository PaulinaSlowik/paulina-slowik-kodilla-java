package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {
    public static void main(String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();

        //Jednak jeśli zdarzy się sytuacja, w której będziesz musiał wyciągnąć obiekt przy pomocy jego indeksu, warto wykorzystać wcześniej metodę size() dostępną w kolekcji List
        // Dzięki takiej operacji zawsze możesz być pewien, że wyciągane przez Ciebie obiekty przy pomocy indeksu, będą znajdować się wewnątrz tablicy
        if(collection.size() > 2) {
            String movie = collection.get(0);
            System.out.println(movie);

            String anotherMovie = collection.get(2);
            System.out.println(anotherMovie);
        }
    }
}
