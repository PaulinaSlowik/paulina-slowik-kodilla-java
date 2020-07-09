package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(5,10));//czy wpisanie konkretnych wartości a i b, to może być test dla metody?
        System.out.println(calculator.subtract(10,5));
    }
}
