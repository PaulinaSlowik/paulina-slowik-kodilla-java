package com.kodilla.spring.intro.shape;

public class Drawer {
    //pole shape typu Shape
    final Shape shape;

    public Drawer(final Shape shape){
        this.shape=shape;
    }

    public String doDrawing() {
        return shape.draw();
    }

//        Shape shape;
//
//        shape =  new Circle();
//        shape.draw();
//
//        shape = new Triangle();
//        shape.draw();

//        Circle circle = new Circle();
//        Triangle triangle = new Triangle();
//
//        circle.draw();
//        triangle.draw();
//    }
}
