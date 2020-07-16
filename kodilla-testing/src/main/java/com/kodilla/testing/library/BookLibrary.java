package com.kodilla.testing.library;

//ta klasa będzie pozwalała na wypożyczenie książek czytelnikom oraz przyjmowanie zwrotów książek do biblioteki
//drugi zespół pracuje w tym czasie nad zestawem klas służących do zapisywania stanu wypożyczeń oraz stanu księgozbioru biblioteki w bazie danych naszego systemu
public class BookLibrary {

    LibraryDatabase libraryDatabase;

//konstrukotr służący do tego że podczas tworzenia obiektu klasy BookLibrary będę do tej klasy "wstrzykiwać" przez konstruktor obiekt obsługujący bazę danych
    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }
}
