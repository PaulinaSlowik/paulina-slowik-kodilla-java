package com.kodilla.patterns.builder.checkers;

import org.junit.Assert;
import org.junit.Test;

public class CheckersTestSuite {
    @Test
    public void testCheckersBuilder() {
        //Given
        //w użyciu jest korzystanie z Buildera. Możemy w bardzo czytelny sposób stworzyć grę z dowolnym początkowym ustawieniem figur na planszy.
        //W naszym przykładzie na planszy znajdują się dwa pionki (biały i czarny), oraz jedna damka (biała).
        Checkers checkers = new Checkers.CheckersBuilder()
                .PlayerOne("John")
                .PlayerTwo("Theresa")
                .Figure(FigureFactory.PAWN, Figure.WHITE, 0, 3)
                .Figure(FigureFactory.PAWN, Figure.BLACK, 9, 7)
                .Figure(FigureFactory.QUEEN, Figure.WHITE, 0, 2)
                .build();
        System.out.println(checkers.getBoard());

        //When
        //pobieramy wszystkie trzy figury z planszy oraz — dla sprawdzenia — próbujemy pobrać figurę z pola, na którym nie stoi żadna figura
        Figure figureOne = checkers.getBoard().getFigure(0, 3);
        Figure figureTwo = checkers.getBoard().getFigure(9, 7);
        Figure figureThree = checkers.getBoard().getFigure(0, 2);
        Figure figureFour = checkers.getBoard().getFigure(1, 1);

        //Then
        //sprawdza czy pobrane wartości zgadzają się z oczekiwanymi
        Assert.assertEquals(Figure.WHITE, figureOne.getColor());
        Assert.assertEquals(Pawn.class, figureTwo.getClass());
        Assert.assertEquals(Queen.class, figureThree.getClass());
        Assert.assertNull(figureFour);
    }
}