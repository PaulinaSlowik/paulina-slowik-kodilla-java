package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;
import java.lang.*;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @Test
    public void testOddNumberExterminatorEmptyList(){
        //Given
        ArrayList<Integer> emptyList =new ArrayList<Integer>();
        //When
        ArrayList<Integer> list = OddNumbersExterminator.exterminate(emptyList);
        System.out.println("Testing "+ list);
        //Then
        Assert.assertEquals(emptyList,list);
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer>oddNumbers = new ArrayList<Integer>();
        oddNumbers.add(9);
        oddNumbers.add(11);
        oddNumbers.add(13);
        ArrayList<Integer>expectedList = new ArrayList<Integer>();
        //When
        ArrayList<Integer> listOdd = OddNumbersExterminator.exterminate(oddNumbers);
        System.out.println("Testing " + listOdd);
        //Then
        Assert.assertEquals(expectedList, listOdd);
    }
    @Test
    public void testEvenNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer>evenNumbers = new ArrayList<Integer>();
        evenNumbers.add(8);
        evenNumbers.add(18);
        evenNumbers.add(20);
        evenNumbers.add(28);
        //When
        ArrayList<Integer> listEven = OddNumbersExterminator.exterminate(evenNumbers);
        System.out.println("Testing " + listEven);
        //Then
        Assert.assertEquals(evenNumbers,listEven);
    }
    @Test
    public void testMixedNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer>mixedNumbers = new ArrayList<Integer>();
        mixedNumbers.add(8);
        mixedNumbers.add(9);
        mixedNumbers.add(16);
        mixedNumbers.add(17);
        mixedNumbers.add(20);
        mixedNumbers.add(21);
        mixedNumbers.add(22);
        ArrayList<Integer>expectedValues = new ArrayList<Integer>();
        expectedValues.add(8);
        expectedValues.add(16);
        expectedValues.add(20);
        expectedValues.add(22);
        //When
        ArrayList<Integer> listMixed = OddNumbersExterminator.exterminate(mixedNumbers);
        System.out.println("Testing " + listMixed);
        //Then
        Assert.assertEquals(expectedValues,listMixed);
    }
}
