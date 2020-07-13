package com.kodilla.testing.shape;

import java.util.ArrayList;

interface Shape{
    //metoda która zwraca nazwę figury
    String getShapeName();
    //metoda która zwraca obliczone pole powierzchni firgury
    double getField();
}
class Square implements Shape{
    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return 100;
    }
}
class Triangle implements Shape{
    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return 200;
    }
}
class Circle implements Shape{
    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return 300;
    }
}
public class ShapeCollector {
    private ArrayList<Shape> shapeCollection = new ArrayList<Shape>();
    private Shape shape;
    public void ShapeCollection(Shape shape){
        this.shape=shape;
    }
    public Shape getShapeCollection(){
        return this.shape;
    }

    //metoda dodawania figury do kolekcji
    public void addFigure(Shape shape){
        shapeCollection.add(shape);
    }

    //metoda do odczytu wszystkich pół (geterów)
    public int getAddFigureQuantity(){
        return shapeCollection.size();
    }

    //metoda usuwająca figurę z kolekcji
    public void removeFigure(Shape shape){
        shapeCollection.remove(shape);
    }

    //metoda pobierająca z kolekcji figurę z pozycji n listy
    public Shape getFigure(int n) {
        if (shapeCollection.size() > n && n >= 0) {
            shapeCollection.get(n);
        }
        //for (n = 0; n <= shapeCollection.size(); n++) {
            //System.out.println("Figure from position " + n + " is: " + shapeCollection.get(n));
    }

    //metoda wyświetla wszystkie figury
    public void showFigures(){
        System.out.println(getShapeCollection().getShapeName());
    }
}
