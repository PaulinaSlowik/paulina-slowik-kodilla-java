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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShapeCollector that = (ShapeCollector) o;

        if (shapeCollection != null ? !shapeCollection.equals(that.shapeCollection) : that.shapeCollection != null)
            return false;
        return shape != null ? shape.equals(that.shape) : that.shape == null;
    }

    @Override
    public int hashCode() {
        int result = shapeCollection != null ? shapeCollection.hashCode() : 0;
        result = 31 * result + (shape != null ? shape.hashCode() : 0);
        return result;
    }
}
