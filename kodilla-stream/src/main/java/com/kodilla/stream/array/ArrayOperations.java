package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[]numbers){
        //stworzenie strumienia składającego się z liczb typu int o zakresach numerów od 0 do numbers.length()
        IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                .forEach(System.out::println);

        return IntStream.range(0, numbers.length)
                .map(i -> numbers[i])
                //oblicza średnią
                .average()
                //zwrócenie średniej jako wynik typu double
                .getAsDouble();
    }
}
