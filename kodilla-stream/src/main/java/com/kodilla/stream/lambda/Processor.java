package com.kodilla.stream.lambda;

public class Processor {
    //metoda przyjmująca jako argument obiekt dowolnej klasy implementującej interfejs Executor.
    public void execute(Executor executor) {

        executor.process();
    }
}
