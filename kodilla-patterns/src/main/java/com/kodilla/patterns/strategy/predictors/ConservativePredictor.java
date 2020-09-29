package com.kodilla.patterns.strategy.predictors;

import com.kodilla.patterns.strategy.BuyPredictor;

//algorytm inwestycyjny zwracający informację o papierach wartościowych, jakie najlepiej jest w danym momencie kupować tzn.proponuje zakup obligacji emitowanych przez XYZ
public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}