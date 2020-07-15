package com.kodilla.testing.shape;

import java.util.ArrayList;

interface Shape{
    //metoda która zwraca nazwę figury
    String getShapeName();
    //metoda która zwraca obliczone pole powierzchni firgury
    double getField();
}
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
class Circle implements Shape{
    private String name;
    private double r; // circleRadius

    public Circle(String name, double r) {
        this.name = name;
        this.r = r;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 3.14*r*r;
    }

    @Override
    public String toString() {
        return name + " with radius: " + r + " and fi 3,14. Got field: " + getField();
    }
}
public class ShapeCollector {
    //przechowywanie figur geometrycznych w kolekcji ArrayList
    private ArrayList<Shape> shapeCollection = new ArrayList<Shape>();
    private Shape shape;

    public void shapeCollection(Shape shape){
        this.shape=shape;
    }

    public Shape getShapeCollection(){
        return this.shape;
    }

    //metoda dodawania figury do kolekcji
    public void addFigure(Shape shape){
        shapeCollection.add(shape);
    }

    //metoda usuwająca figurę z kolekcji
    public void removeFigure(Shape shape){
        shapeCollection.remove(shape);
    }

    //metoda pobierająca z kolekcji figurę z pozycji n listy
    public Shape getFigure(int n) {
        return shapeCollection.get(n);
    }

    //metoda wyświetla wszystkie figury lub inaczej metoda do odczytu wszystkich pól (geterów)
    public int showFigures(){
        return shapeCollection.size();
    }
}
