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
        ArrayList<Integer> even  = new ArrayList<Integer>(Arrays.asList(8,12,18,20,26,30));
        ArrayList<Integer> odd  = new ArrayList<Integer>(Arrays.asList(8,18,30));
        //When
        ArrayList<Integer> listEven = OddNumbersExterminator.exterminate(even);
        ArrayList<Integer> listOdd = OddNumbersExterminator.exterminate(odd);
        System.out.println("Testing " + listEven);
        System.out.println("Testing " + listOdd);
        //Then
        assertEquals(Arrays.asList(even), Arrays.asList(listEven));
        assertEquals(Arrays.asList(odd), Arrays.asList(listOdd));
        //Assert.assertArrayEquals(even.size(),listEven.size());
        //Assert.assertArrayEquals(odd.size(),listOdd.size());
    }
}
