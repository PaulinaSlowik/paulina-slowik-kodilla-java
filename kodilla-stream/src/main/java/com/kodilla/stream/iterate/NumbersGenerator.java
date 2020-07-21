package com.kodilla.stream.iterate;
//import biblioteki java.util.stream
import java.util.stream.*;

public class NumbersGenerator {
    //metoda statyczna generateEven(int max), której zadaniem jest wygenerowanie kolejnych liczb parzystych. Metoda otrzymuje jeden argument wejściowy max mówiący o tym ile liczb "pozwalamy" wygenerować naszemu strumieniowi Stream
    public static void generateEven(int max){
        //wywołanie metody statycznej iterate(Integer seed, UnaryOperator f) interfejsu Stream.
        //metoda iterate tworzy strumień obiektów typu Integer o wartości początkowej określonej przez argument seed czyli 1
        //wartości kolejnych obiektów w strumieniu wyznaczone są przez wyrażenie lambda f (lub referencję do metody). Wyrażenie lambda otrzymuje jeden argument wejściowy (aktualną wartość obiektu w strumieniu) a jgo zadaniem jest zwrócenie kolejnej wartości (poniżej wyrażenie lambda inkrementuje arguent tzn że kolejne obiekty w strumieniu będą miały wartość o jeden większą od poprzedniego (n -> n + 1)
        Stream.iterate(1,n -> n + 1)
                //wywołąnie metody limit(long maxSize) interfejsu Stream która ogranicza wielkość strumienia do maxSize obiektów (opreracja filtrująca), więc po wywołąniu tego powstaje nowy Stream
                .limit(max)
                //na nowym Stream wywołanie metody filter (Predicate predicate) gdzie predicate jest wyrażeniem lambda które powinno zwracać true, gdy obiekt ma pozostać w strumieniu oraz wartość false gdy obiekt powinien zostać "odrzucony" i nie przekazany do strumienia wyjściowego metody filter(Predicate predicate), jest to opracja filtrująca
                .filter(n -> n % 2 == 0)
                //metoda forEach(Consumer action) zamyka strumień i przekształca go w końcowy typ konkretny czyli jest metodą terminalną. Działanie tej metody polega na wykonaniu dla każdego obiektu w strumieniu wyrażenia lambda- action (lub może też wykonywać referencję do metody). Typem zwracanym przez for Each (Consumer action) jest typ void (nie powstaje żadna kolekcja czy finalny zbiór danych- obiekty są niszczone). Jednak ta metoda została wykorzystana do wyświetlenia na ekranie konsoli wszystkich obiektow ze strumienia i tak też zrobiliśmy wskazując metodę System.out::println jako metodę która ma być wykonana na każdym obiekcie w strumieniu (jest to operacja terminalna-kolektor).
                .forEach(System.out::println);
    }
}
