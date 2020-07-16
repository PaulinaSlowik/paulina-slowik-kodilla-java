package com.kodilla.testing.shape;

import java.util.ArrayList;

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
