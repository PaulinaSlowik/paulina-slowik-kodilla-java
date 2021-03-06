package com.kodilla.patterns.factory.tasks;


public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String newTask){
        switch(newTask){
            case SHOPPING:
                return new ShoppingTask("Shopping Task","Bread",1.5);
            case PAINTING:
                return new PaintingTask("Painting Task","Red","Bed");
            case DRIVING:
                return new DrivingTask("Driving Task","Cracov","BMW");
            default:
                return null;
        }
    }
}