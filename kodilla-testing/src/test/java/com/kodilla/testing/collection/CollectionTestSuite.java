package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;


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
        ArrayList<Integer> even  = new ArrayList<Integer>(Arrays.asList(8,12,18,20,26,30));
        ArrayList<Integer> odd  = new ArrayList<Integer>(Arrays.asList(7,11,15,19,23,33));
        //When
        ArrayList<Integer> listEven = OddNumbersExterminator.exterminate(even);
        ArrayList<Integer> listOdd = OddNumbersExterminator.exterminate(odd);
        System.out.println("Testing " + listEven);
        System.out.println("Testing " + listOdd);
        //Then
        Assert.assertArrayEquals(even,listEven);
        Assert.assertArrayEquals(odd,listOdd);
    }
}
