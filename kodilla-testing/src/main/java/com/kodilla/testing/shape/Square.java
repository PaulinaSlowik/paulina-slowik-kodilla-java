package com.kodilla.testing.shape;

class Square implements Shape{
    private String name;
    private double a; //sideLengthOfSquare

    public Square(String name, double a) {
        this.name = name;
        this.a = a;
    }

    @Override
    public String getShapeName() {

        return name;
    }
    @Override
    public double getField() {

        return a*a;
    }
    @Override
    public String toString() {
        return name + " with side: " + a + " .Got field: " + getField();
    }

}
