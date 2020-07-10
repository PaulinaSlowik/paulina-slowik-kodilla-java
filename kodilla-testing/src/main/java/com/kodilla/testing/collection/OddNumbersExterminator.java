package com.kodilla.testing.collection;
import java.util.ArrayList;

public class OddNumbersExterminator {

    ArrayList<Integer> numbers = new ArrayList<Integer>();

    static ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
        ArrayList<Integer> numbersWithoutOdd = new ArrayList<>();
        for(int number : numbers){
            if (number%2==0){
                numbersWithoutOdd.add(number);
            }
        }
        return numbersWithoutOdd;
    }
}