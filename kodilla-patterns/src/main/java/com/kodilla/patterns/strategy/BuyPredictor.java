package com.kodilla.patterns.strategy;

//interfejs, który służy do wywoływania metody wskazującej papiery wartościowe do kupienia
public interface BuyPredictor {
    String predictWhatToBuy();
}