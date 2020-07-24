package com.kodilla.stream.book;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {
    @Test
    public void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        //z obiektu bookDirectory klasy BookDirectory pobierana jest kolekcja książek przy pomocy metody getList()
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        //przy pomocy pętli for iterujemy po kolekcji i zliczamy w zmiennej numberOfBookPublicatedAfter2007 typu int liczbę książek które były wydane po 2007 roku
        for(Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        //wywołanie asercji sprawdzającej czy takich książek było dokładnie trzy
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
    @Test
    public void testGetListUsingIntStream(){
        //Given
        BookDirectory bookDirectory = new BookDirectory();
        //When
        List<Book>books = bookDirectory.getList();
        //Then
        //tworzymy i uruchamiamy strumień elementów typu int o zakresach numerów od 0 do books.size(), za pomocą IntStream.range(int startInclusive, int endExclusive) — tworzy strumień składający się z liczb typu int lub long o wartościach od startInclusive do endExclusive-1
        //Wynik działania tego strumienia, po jego zakończeniu, zostanie przypisany do zmiennej numberOfBooksPublicatedAfter2007
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                //odfiltrowujemy tylko te książki, których rok wydania jest większy od 2007. Realizujemy to przy pomocy wyrażenia lambda,
                //które otrzymuje na wejściu kolejną wartość indeksu n. Do strumienia wyjściowego filtra kierowane są jedynie te numery indeksów (nie książki!), które odpowiadają książkom wydanym po roku 2007.
                //Sprawdzamy to przy pomocy warunku books.get(n).getYearOfPublication() > 2007.
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                //na wejściu otrzymujemy strumień liczb typu int, które są numerami indeksów książek wydanych po 2007 roku w kolekcji books. Każdy taki indeks odpowiada jednej książce do "zliczenia".
                //Dokonujemy więc transformacji strumienia w taki sposób, że do strumienia wyjściowego trafia liczba 1 w miejsce każdego elementu strumienia do zliczenia
                .map(n -> 1)
                //zliczamy liczbę "jedynek" w strumieniu wejściowym. Odpowiada ona liczbie książek wydanych po roku 2007 w kolekcji
                .sum();
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
    @Test
    public void testGetListUsingCount(){
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        //musimy również zmienić typ zmiennej numberOfBooksPublicatedAfter2007 na typ long (co wynika z tego, że kolektor count() zwraca wynik typu long)
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                //operacja terminalna count() strumienia. Operacja ta jest kolektorem skalarnym i zwraca liczbę typu long.
                //W przypadku zastosowania metody count(), nie musimy mapować indeksów na "jedynki" — chcemy po prostu sprawdzić liczbę indeksów w strumieniu po filtrze.
                .count();
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}
