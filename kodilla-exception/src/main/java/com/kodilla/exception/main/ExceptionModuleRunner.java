package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        //FileReader fileReader = new FileReader();
        //fileReader.readFile();

        //stwórz obiekt naszej nowej klasy FileReaderWithoutHandling wraz z wywołaniem metody readFile().
        //FileReaderWithoutHandling fileReader = new FileReaderWithoutHandling();
        //fileReader.readFile();

        FileReader fileReader = new FileReader();

        fileReader.readFile();
    }
}
