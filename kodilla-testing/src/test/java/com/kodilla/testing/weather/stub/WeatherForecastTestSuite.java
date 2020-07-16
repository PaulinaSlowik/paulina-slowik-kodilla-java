package com.kodilla.testing.weather.stub;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}

class TemperaturesStub implements Temperatures {
    @Override
    public HashMap<Integer, Double> getTemperatures() {
        HashMap<Integer, Double> stubResult = new HashMap<Integer, Double>();

        // dummy data
        stubResult.put(0, 25.5);
        stubResult.put(1, 26.2);
        stubResult.put(2, 24.8);
        stubResult.put(3, 25.2);
        stubResult.put(4, 26.1);

        return stubResult;
    }
}