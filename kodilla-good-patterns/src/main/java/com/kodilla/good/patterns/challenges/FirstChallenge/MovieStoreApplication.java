package com.kodilla.good.patterns.challenges.FirstChallenge;

import java.util.stream.Collectors;

public class MovieStoreApplication {
    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        String theResultStringOfBooks = movieStore.getMovies().entrySet().stream()
                .flatMap(book -> book.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(theResultStringOfBooks);
    }
}
