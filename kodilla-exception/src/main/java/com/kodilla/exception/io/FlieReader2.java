package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FlieReader2 {
    //rzucamy błąd, sygnalizujemy to słowem kluczowym throws przy nazwie metody - tuż po nim umieściliśmy typ naszego wyjątku - FileReaderException
    //zauważ, że w tym przypadku nie musieliśmy tworzyć instancji tej klasy, a daliśmy Javie znać, że rzucany błąd będzie tego typu
    public void readFile() throws FileReaderException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());

        try (Stream<String> fileLines = Files.lines(Paths.get("test.txt"))){

            fileLines.forEach(System.out::println);
            //Jak widzisz, wewnątrz bloku catch 'łapiemy' wyjątek IOException i kiedy wystąpi, rzucamy nasz wyjątek FileReaderException -
            //zauważ, że kiedy rzucamy błąd za pomocą throw, musimy najpierw stworzyć jego instancję za pomocą new -
            //w końcu błędy i wyjątki też są zwykłymi klasami, tyle że dziedziczą po Error lub Exception.
        } catch (IOException e) {
            throw new FileReaderException();
        } finally {
            System.out.println("I am gonna be here.. always!");
        }
    }
}
