package com.kodilla.patterns.factory;

//Interfejs ten zawiera trzy metody
public interface Shape {
    //nazwę figury
    String getName();
    //pole powierzchni figury
    double getArea();
    //obwód figury
    double getCircumference();
}