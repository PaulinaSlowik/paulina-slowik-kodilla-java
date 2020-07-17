/*package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

//ta klasa będzie pozwalała na wypożyczenie książek czytelnikom oraz przyjmowanie zwrotów książek do biblioteki
//drugi zespół pracuje w tym czasie nad zestawem klas służących do zapisywania stanu wypożyczeń oraz stanu księgozbioru biblioteki w bazie danych naszego systemu
public class BookLibrary {

    LibraryDatabase libraryDatabase;

//konstrukotr służący do tego że podczas tworzenia obiektu klasy BookLibrary będę do tej klasy "wstrzykiwać" przez konstruktor obiekt obsługujący bazę danych
    public BookLibrary(LibraryDatabase libraryDatabase) {

        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment){
        /*TDD
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book ("The book title", "The book author", 2000);
        bookList.add(book);

        //temporary returning list of one book
        return bookList;
        *//*
        //KOD PO ZAIMPLEMENTOWANIU METODY
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public
}*/