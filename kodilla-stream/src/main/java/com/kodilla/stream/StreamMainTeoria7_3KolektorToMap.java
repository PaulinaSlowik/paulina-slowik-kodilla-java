package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMainTeoria7_3KolektorToMap {
    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                //używamy kolektora Collectors.toMap(Function keyMapper, Function valueMapper),
                //gdzie keyMapper jest funkcją (wyrażeniem lambda lub referencją do metody) obliczającą klucz (key) pary w mapie wynikowej,
                //natomiast valueMapper jest funkcją (wyrażeniem lambda lub referencją do metody) zwracającą wartość obiektu (value) pary w mapie wynikowej.
                //W naszym przypadku:
                //klucze par Entry w mapie obliczane są funkcją, która wskazana jest przez referencję do metody Book::getSignature
                //wartości par Entry w mapie obliczane są funkcją zapisaną przy pomocy wyrażenia lambda book -> book, czyli po prostu są obiektami przepisanymi ze strumienia
                .collect(Collectors.toMap(Book::getSignature, book -> book));
        //sprawdzamy rozmiar kolekcji wynikowej
        System.out.println("# elements: " + theResultMapOfBooks.size());
        //wyświetlamy zawartość mapy w formacie "klucz: wartość" przy pomocy wyrażenia lambda konwertującego typ Map.Entry na łańcuchy tekstowe, a następnie przy pomocy metody System.out::println.
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}


