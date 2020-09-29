package com.kodilla.patterns.strategy.predictors;

import com.kodilla.patterns.strategy.BuyPredictor;

//algorytm inwestycyjny zwracający informację o papierach wartościowych, jakie najlepiej jest w danym momencie kupować tzn.proponuje zakup jednostek inwestycyjnych w funduszu XYZ
public class BalancedPredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Balanced predictor] Buy shared units of Fund XYZ";
    }
}