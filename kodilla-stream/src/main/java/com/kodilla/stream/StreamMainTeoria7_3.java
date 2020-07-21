package com.kodilla.stream;

import com.kodilla.stream.person.People;

public class StreamMainTeoria7_3 {

    public static void main(String[] args) {
        /*
        //Stream w kolekcjach
        //wywołanie metody statycznej getList() klasy People w wyniku czego otrzymujemy kolekcję typu List<String> zawierającą imiona i nazwiska osób
        //następnie wywołujemy metodę stream() tej kolekcji któa inicjuje strumień
        People.getList().stream()
                //na powołanym do życia strumieniu wywołujemy jedną operację terminalną forEach(Customer action), która na każdym obiekcie w kolekcji wykonuje metodę println(String x) obiektu typu PrintStream zwracanego przez metodę statyczną out klasy System (czyli mówiąc krótko wykonuje System.out.println() na każdym obiekcie kolekcji).
                //Operacja terminalna forEach(Consumer action) kończy przepływ strumienia. Sama zwraca void, więc nie powstaje żadna kolekcja wynikowa. Na ekranie konsoli natomiast pojawi się lista imion i nazwisk wyświetlonych z kolekcji wejściowej
                .forEach(System.out::println);

        //Operacje Pośrednie a dokładnie transformujące na Stream (zmieniające właściwośći obiektów w strumieniu)
        People.getList().stream()
                //metoda map(Function mapper) gdzie mapper to wyrażenie lambda (s -> s.toUpperCase()) otrzymujące jeden argument wejściowy(bieżący obiekt w strumieniu)które powinno zwrócić przekształcony obiekt
                //Dla każdego obiektu typu String zapisanego w kolekcji zwróconej przez People.getList(), podane w metodzie .map() wyrażenie lambda wywołuje jego metodę toUpperCase() (jest to metoda udostępniana przez klasę String), która zwraca tekst zawarty w obiekcie zmodyfikowany w ten sposób, że jest w całości zapisany dużymi literami.
                .map(s -> s.toUpperCase())
                //wyświetlamy przy pomocy kolektora zawartość strumienia na ekran konsoli
                .forEach(System.out::println);
        //można zamiennie zastosować referencję do metody toUppercase()klasy String tzn.:
        //       .map(String::toUpperCase)- zamienliśmy wyrażenie lambda na referencję do metody
        //       .forEach(s -> System.out.println(s));- zamieniliśmy referencję do metody na wyrażenie lambda

        //Operacje Pośrednie a dokłądnie filtrujące na Stream
        People.getList().stream()
                //podstawowa operacja filtrująca: filter(Predicate predicate), gdzie predicate jest wyrażeniem lambda zwracającym true, gdy obiekt ma przejść przez filtr i być przekazany do strumienia wyjściowego operacji, oraz false, gdy obiekt ma być odrzucony przez filtr i nie ma być przekazywany do strumienia wyjściowego operacji.
                //wyrazenie lambda s -> s.length() > 11 otrzymje na wejściu obiekt s typu String a następnie wywołuje jego metodę length(). Jeżeli zwrócona długość napisu jest większa niż 11 znaków, wówczas wyrażenie po prawej stronie operatora -> zwróci wartość true i obiekt zostanie przekazany dalej w łańcuchu operacji strumienia.
                //wyświetlane są jedynie obiekty któryc długość napisu reprezentującego imię i nazwisko jest większa niż 11 znaków
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);
         */
        //Kaskadowe łączenie operacji na Stream
        People.getList().stream()
                //wszystkie teksty w obiektach zamieniane są na teksty pisane wielkimi literami poprzez wywołanie dla każdego obiektu kodu, wskazanego referencją do metody toUpperCase() klasy String,
                .map(String::toUpperCase)
                //przy pomocy wyrażenia lambda odfiltrowane zostają jedynie te teksty, których długość jest większa od 11 znaków
                .filter(s -> s.length() > 11)
                //teksty obiektów zastępowane są nowymi. Ze starego tekstu pobierane są znaki od początku napisu do spacji (plus dwa znaki — sama spacja oraz pierwsza litera nazwiska), a na końcu dodawana jest kropka
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                //odfiltrowane zostają jedynie te obiekty, których pierwszą literą imienia jest litera M
                .filter(s -> s.substring(0, 1).equals("M"))
                //obiekty ze strumienia wynikowego są wyświetlane na ekranie konsoli przy pomocy kolektora forEach() z referencją do metody System.out::println
                .forEach(System.out::println);
    }
}
