package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country country1 = new Country("China",new BigDecimal("3425879547898"));
        Country country2 = new Country("India",new BigDecimal("12358954456"));
        Country country3 = new Country("Pakistan",new BigDecimal("25489626"));
        Country country4 = new Country("Nigeria",new BigDecimal("25879547"));
        Country country5 = new Country("Egypt",new BigDecimal("795478965"));
        Country country6 = new Country("Ethiopia",new BigDecimal("795475458"));
        Country country7 = new Country("Russia",new BigDecimal("879565458"));
        Country country8 = new Country("Germany",new BigDecimal("5879547458"));
        Country country9 = new Country("Poland",new BigDecimal("3425478968"));

        Continent continent1 = new Continent("Asia");
        continent1.addListOfCountry(country1);
        continent1.addListOfCountry(country2);
        continent1.addListOfCountry(country3);
        Continent continent2 = new Continent("Africa");
        continent2.addListOfCountry(country4);
        continent2.addListOfCountry(country5);
        continent2.addListOfCountry(country6);
        Continent continent3 = new Continent("Europe");
        continent3.addListOfCountry(country7);
        continent3.addListOfCountry(country8);
        continent3.addListOfCountry(country9);

        World world = new World();
        world.addListOfContinent(continent1);
        world.addListOfContinent(continent2);
        world.addListOfContinent(continent3);

        //When
        BigDecimal expected =world.getPeopleQuantity();
        BigDecimal actual = new BigDecimal("3450065417834");

        //Then
        Assert.assertEquals(expected,actual);

    }
    /*@Test- cza dałoby się przeprowadzić test tak aby wpisać wartości w jedną linię? np. coś jak poniżej tylko jakoś rozbudować o argumenty World i Continent.
    public void test2GetPeopleQuantity(){
        //Given
        World world =new World();
        //When
        world.addListOfContinent(new Continent(new Country("Poland", new BigDecimal("123456789"))));
        ...
        //Then
        Assert.assertEquals(123456789,world.getPeopleQuantity());
    }*/
}
