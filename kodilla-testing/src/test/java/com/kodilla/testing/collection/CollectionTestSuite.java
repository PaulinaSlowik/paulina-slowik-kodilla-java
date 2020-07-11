package com.kodilla.testing.collection;

import org.junit.*;
import java.util.*;

import static org.junit.Assert.assertEquals;

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
        assertEquals(emptyList,list);
    }
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer>oddNumbers = new ArrayList<Integer>();
        oddNumbers.add(8);
        oddNumbers.add(12);
        oddNumbers.add(18);
        oddNumbers.add(20);
        oddNumbers.add(26);
        //ArrayList<Integer> evenAndOdd  = new ArrayList<Integer>(Arrays.asList(8,9,12,15,18,20,25,26,30));
        //ArrayList<Integer> odd  = new ArrayList<Integer>(Arrays.asList(9,15,25,26));
        //When
        ArrayList<Integer> listOdd = OddNumbersExterminator.exterminate(oddNumbers);
        System.out.println("Testing " + listOdd);
        //Then
        assertEquals(Arrays.asList(oddNumbers), Arrays.asList(listOdd));
    }
    @Test
    public void testEvenNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer>evenNumbers = new ArrayList<Integer>();
        evenNumbers.add(9);
        evenNumbers.add(13);
        evenNumbers.add(19);
        evenNumbers.add(21);
        evenNumbers.add(27);
        //When
        ArrayList<Integer> listEven = OddNumbersExterminator.exterminate(evenNumbers);
        System.out.println("Testing " + listEven);
        //Then
        assertEquals(Arrays.asList(evenNumbers), Arrays.asList(listEven));
    }
}
