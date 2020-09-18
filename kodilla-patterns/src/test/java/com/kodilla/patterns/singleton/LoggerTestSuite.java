package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;
import sun.rmi.runtime.Log;

public class LoggerTestSuite {
    @Test
    public void testLog() {
        //Given
        String log1= "First log";
        String log2= "Second log";
        //When
        Logger.getInstance().log(log1);
        Logger.getInstance().log(log2);
        //Then
        Assert.assertEquals(log2,Logger.getInstance().getLastLog());
    }
    @Test
    public void  testAnotherLastLog() {
        //Given
        Logger.getInstance().log("Last log");
        //When
        String result = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Last log",result);
    }
    @Test
    public void testGetInstaceOnlyOnce() {
        //given
        Logger excpectedInstance = Logger.getInstance();
        //when
        Logger actualInstance = Logger.getInstance();
        Assert.assertTrue(excpectedInstance == actualInstance);
    }
}
