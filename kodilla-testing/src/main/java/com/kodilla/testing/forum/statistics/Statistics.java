package com.kodilla.testing.forum.statistics;

import java.util.List;

interface Statistics {
    List<String> usersNames(); //lista imion użytowników
    int postsCount(); // całkowita ilość postów na forum
    int commentsCount(); //całkowita ilość komentarzy na forum
}


