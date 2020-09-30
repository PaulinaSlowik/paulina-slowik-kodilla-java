package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;


public class TaskFactoryTestSuite {
    @Test
    public void testShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING);
        shoppingTask.executeTask();
        //Then
        Assert.assertFalse(shoppingTask.isTaskExecuted());
        Assert.assertEquals("Shopping Task", shoppingTask.getTaskName());
    }
    @Test
    public void testPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTING);
        paintingTask.executeTask();
        //Then
        Assert.assertFalse(paintingTask.isTaskExecuted());
        Assert.assertEquals("Painting Task", paintingTask.getTaskName());
    }
    @Test
    public void testDrivingingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVING);
        drivingTask.executeTask();
        //Then
        Assert.assertFalse(drivingTask.isTaskExecuted());
        Assert.assertEquals("Driving Task", drivingTask.getTaskName());
    }
}
