package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator)context.getBean("calculator");
        //When
        double addResult = calculator.add(6,3);
        double subResult = calculator.sub(6,3);
        double mulResult = calculator.mul(6,3);
        double divResult = calculator.div(6,3);
        //Then
        Assert.assertEquals(9,addResult,0);
        Assert.assertEquals(3,subResult,0);
        Assert.assertEquals(18,mulResult,0);
        Assert.assertEquals(2,divResult,0);
    }
}