package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile(){
        //Klasa ClassLoader jest to klasa odpowiedzialna za odnalezienie klas i plików wewnątrz naszej aplikacji - pozwoli nam to odwołać się do naszego pliku z imionami (names.txt)
        //getClass() zwraca klasę, w której jest wywołana (FileReader)
        //obiekt typu ClassLoader, który tu pobieramy przy pomocy metody getClass().getClassLoader()

        ClassLoader classLoader = getClass().getClassLoader();

        //classLoader.getResource(“...”).getFile() Jest to wywołanie metody, która wskazuje klasie ClassLoader, gdzie powinna szukać pliku,
        //tu: w katalogu file, w którym umieściliśmy nasz plik names.txt (metoda ta zawsze szuka zasobów wewnątrz katalogu resources).
        //pobieramy tak zwany “uchwyt” do pliku za pomocą metody getFile(), co pozwoli nam przekazać odwołanie do tego pliku w następnym kroku
        //new File() Dzięki wywołaniu metody getFile() w poprzednim kroku, mamy już dostęp do pliku z imionami z poziomu kodu -
        //teraz jesteśmy w stanie stworzyć obiekt reprezentujący nasz plik tekstowy za pomocą klasy File, które również jest dostępna wewnątrz biblioteki Javy - java.io.

        File file = new File(classLoader.getResource("file/names.txt").getFile());

        //Aby sprawdzić czy nasz plik tekstowy otworzył się odpowiednio, wywołajmy z obiektu file metodę getPath(),
        //która zwróci nam dokładną ścieżkę do naszego pliku names.txt, a następnie wyświetlmy ją za pomocą System.out.println()

        //System.out.println(file.getPath());

        //przełożenie naszej ścieżki na obiekt za pomocą klasy Paths
        //Klasa Paths pozwala nam na modyfikacje ścieżki o typie String na obiekt Path, który będzie niezbędny do dalszego działania z plikiem.

        Path path = Paths.get(file.getPath());

        //Path path = Paths.get("files/test.txt");//popsucie ścieżki


        //jak posiadamy obiekt klasy Path to trzeba napisać klasę która pozwoli przeczytać zawartość pliku
        //pomoże nam w tym klasa Files, która pozwala między innymi na czytanie z pliku tekstowego - dysponuje ona metodą lines(), która właśnie pozwala na tego typu operacje.
        //Wynikiem wywołania metody lines() jest Stream obiektów typu String - obiektów reprezentujących poszczególne linie w pliku tekstowym.
        //W naszym przypadku będą to imiona, które zapisaliśmy w pliku tekstowym names.txt.
        //Metoda lines() “wie” jak czytać plik linia po linii i od razu gwarantuje nam przełożenie linii pliku tekstowego na obiekty typu String.

        //Stream<String> fileLines =  Files.lines(path);

        //jednak tutaj występuje problem związany z wywołaniem metody lines()? IntelliJ informował nas, że nie obsłużyliśmy wyjątku -
        //IOException, co znaczy że po prostu nie przekazaliśmy programowi instrukcji jak ma się zachować, kiedy w tym miejscu wystąpi dany wyjątek.
        //Jak przekazać programowi taką informację? Zerknij na kod poniżej:


        //Tak działa catch - w razie wypadku nie wyrzuca błędu w konsoli i nie zatrzymuje działania programu,
        //a pozwala na jego sprawną obsługę przez programistę w sekcji catch(Exception e){...} - to tyle - na tym polega cała magia bloku try-catch

        try {
            Stream<String> fileLines =  Files.lines(path);

            //wywołaliśmy metodę forEach() z interfejsu Stream, przekazując jej referencję do metody System.out.println -
            //w efekcie program powinien wyświetlać w konsoli zawartość każdej linijki z naszego pliku

            fileLines.forEach(System.out::println);

            //e- jest to nic innego jak referencja do obiektu wyjątku, który się pojawił w trakcie działania programu - podobnie jak w przypadku definicji argumentów metody,
            //ustalamy tutaj jakiego typu będzie wyjątek i nadajemy mu nazwę, która pozwoli nam odwołać się do niego wewnątrz bloku catch -
            //dzięki temu możemy np. wyświetlić dokładne informacje o błędzie

        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! Error:"+e);
        } finally {
            System.out.println("I am gonna be here... always!");
        }
    }
}
