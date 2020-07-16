package com.kodilla.testing.shape;

class Triangle implements Shape{
    private String name;
    private double a; //lengthOfSideOfTriangle
    private double h; //lengthOfHightOfTriangle

    public Triangle(String name, double a, double h) {
        this.name = name;
        this.a = a;
        this.h = h;
    }

    @Override
    public String getShapeName() {

        return name;
    }

    @Override
    public double getField() {

        return (a*h)/2;

    }

    @Override
    public String toString() {
        return name + " with length of side: " + a + " and length of hight: " + h + ". Got field: " + getField();
    }
}
