package com.kodilla.patterns.strategy;

public class Customer {
    final private String name;
    //pole, do którego będziemy przypisywali właściwy obiekt implementujący interfejs BuyPredictor
    protected BuyPredictor buyPredictor;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //metoda wywołująca z obiektu rekomendującego zakup metodą obliczającą aktualną rekomendację zakupową
    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }

    //metoda pozwalająca ustawić pole: protected BuyPredictor buyPredictor;
    public void setBuyingStrategy(BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
    }
}