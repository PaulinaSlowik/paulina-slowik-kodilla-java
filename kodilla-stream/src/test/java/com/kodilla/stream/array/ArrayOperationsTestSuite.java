package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int[]numbers = new int[] {1,2,3,4,5,6,7};
        //double sum = 0;
        //for(int i=0; i<numbers.length; i++){
          //  sum += numbers[i];
        //}
        //When
        double expected = 4.0;
        //double expected = sum/numbers.length;
        double actual = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

}
