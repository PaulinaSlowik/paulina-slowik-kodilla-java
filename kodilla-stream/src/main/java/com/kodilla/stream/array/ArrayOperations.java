package com.kodilla.stream.array;

import java.util.stream.IntStream;

import static jdk.nashorn.internal.objects.NativeArray.forEach;

public interface ArrayOperations {

    static void getAverage(int[]numbers){
        //stworzenie strumienia składającego się z liczb typu int o zakresach numerów od 0 do numbers.length()
        IntStream.range(0, numbers.length())
                .forEach(System.out::println);

        IntStream.range(0, numbers.length())
                //oblicza średnią
                .average()
                //zwrócenie średniej jako wynik typu double
                .getAsDouble();
    }
}
