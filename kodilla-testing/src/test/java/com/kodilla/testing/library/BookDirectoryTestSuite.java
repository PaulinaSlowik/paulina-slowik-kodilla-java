package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test //ten test sprawdzi, czy lista książek spełniających warunek wyszukiwania jest poprawnie zwracana
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test //ten test posłuży do sprawdzenia, czy metoda listBooksWithCondition(String titleFragment) zachowuje się poprawnie, gdy liczba tytułów pasujących do wzorca jest większa niż 20. W tej sytuacji zwracana powinna być pusta lista.
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test //ten test z kolei ma za zadanie sprawdzenie, czy zwracana lista książek jest pusta, w sytuacji, gdy wyszukiwany fragment tytułu jest krótszy niż trzy znaki.
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }
    @Test //ten test sprawdza trzy scenariusz tzn. gdy użytkownik nie ma wypożyczonych żadnych książek, gdy ma wypożyczoną jedną książkę, gdy ma wypożyczonych 5 książek
    public void testlistBooksInHandsOf() {
        //given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUserNonBooks = new LibraryUser("Adam", "Nowak", "694758");
        LibraryUser libraryUser1Book = new LibraryUser("Anna", "Kowalska", "8015797");
        LibraryUser libraryUser5Book = new LibraryUser("Tomasz", "Niewiadomski", "51015");

        List<Book> listOfLendBooks0 = new ArrayList<>();
        List<Book> listOfLendBooks1 = generateListOfNBooks(1);
        List<Book> listOfLendBooks5 = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserNonBooks)).thenReturn(listOfLendBooks0);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1Book)).thenReturn(listOfLendBooks1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser5Book)).thenReturn(listOfLendBooks5);

        //when
        List<Book> resultList0 = bookLibrary.listBooksInHandsOf(libraryUserNonBooks);
        List<Book> resultList1 = bookLibrary.listBooksInHandsOf(libraryUser1Book);
        List<Book> resultList5 = bookLibrary.listBooksInHandsOf(libraryUser5Book);
        //then
        assertEquals(0, resultList0.size());
        assertEquals(1, resultList1.size());
        assertEquals(5, resultList5.size());
    }
}
