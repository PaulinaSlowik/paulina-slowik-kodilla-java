package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {

    //throws, które zapisuje się po prawej stronie od nazwy metody. Tuż za słowem throws podajemy typ wyjątku, który ma być przekazany dalej - tutaj IOException
    //za pomocą throws przekazaliśmy obsługę wyjątku wyżej, czyli sprawiliśmy że nie musimy się już przejmować tym błędem w metodzie readFile()
    public void readFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
            Stream<String> fileLines = Files.lines(Paths.get(file.getPath()));
            fileLines.forEach(System.out::println);
    }
}
