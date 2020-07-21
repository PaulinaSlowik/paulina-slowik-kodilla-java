package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMainTeoria7_3KolektorToList {
        public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
        //LIST wywołanie operacji terminalnej tworzącą wynikową kolekcję danych przy użyciu metody collect(Collector collector)
        //LIST skorzystanie z kolektora Collectors.toList(), dzięki temu możemy "wynik działania" strumienia przypisać do zmiennej typu List (linia 11)
                .collect(Collectors.toList());

                //LIST wyświetlanie liczby elementów z kolekcji wynikowej
                System.out.println("# elements: " + theResultListOfBooks.size());
                //wyświetlanie zawartości kolekcji przy pomocy pętli metody System.out::println
                theResultListOfBooks.stream()
                .forEach(System.out::println);
    }
}

