package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import java.util.stream.Collectors;

public class StreamMainTeoria7_3KolektorJoining {
    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        //typem zmiennej, do której przypisujemy wynik działania strumienia jest typ String — wynika to z tego, że finalnym efektem działania naszego strumienia Stream jest pojedynczy (skalarny) obiekt typu String
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                //wywoływany jest kolektor Collectors.joining(String delimiter, String prefix, String suffix), gdzie:
                //delimiter ustawiony jest na wartość ",\n"
                //prefix ustawiony jest na wartość "<<"
                //suffix ustawiony jest na wartość ">>"
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
    }
}

//Collectors.joining(String delimiter, String prefix, String suffix).
// Kolektor ten wymaga na wejściu, aby obiekty w strumieniu były przetransformowane do typu String.
// Działanie tego kolektora polega na dokonaniu konkatenacji (połączenia) wszystkich obiektów w strumieniu w jeden ciąg znaków.
// Wynikowy ciąg znaków będzie poprzedzony tekstem przekazanym jako prefix oraz zakończony tekstem przekazanym jako suffix,
// a poszczególne obiekty będą od siebie oddzielone ciągiem znaków przekazanym jako delimiter.