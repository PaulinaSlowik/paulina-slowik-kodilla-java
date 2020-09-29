package com.kodilla.patterns.strategy.predictors;

import com.kodilla.patterns.strategy.BuyPredictor;

//algorytm inwestycyjny zwracający informację o papierach wartościowych, jakie najlepiej jest w danym momencie kupować tzn. proponuje zakup akcji spółki XYZ
public class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}