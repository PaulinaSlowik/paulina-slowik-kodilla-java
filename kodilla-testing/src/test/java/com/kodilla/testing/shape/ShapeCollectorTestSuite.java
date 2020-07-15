package com.kodilla.testing.shape;

import org.junit.*;

//Test suite for classes of ShapeCollector
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTest(){
        System.out.println("All test are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("reparing to execute test #" + testCounter);
    }

    //Test 1: sprawdzający, czy po dodaniu figur do kolekcji liczba figur w kolekcji się zgadza
    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape1 = new Square("square",5);
        Shape shape2 = new Triangle("triangle", 5, 3);
        Shape shape3 = new Circle("circle", 5);
        //When
        shapeCollection.addFigure(shape1);
        shapeCollection.addFigure(shape2);
        shapeCollection.addFigure(shape3);
        //Then
        Assert.assertEquals(3,shapeCollection.showFigures());

    }
    //Test 2: sprawdzający, czy po usunięcie figury lczba figur wynosi 1
    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape1 = new Square("square",5);
        Shape shape2 = new Triangle("triangle", 5, 3);
        Shape shape3 = new Circle("circle", 5);
        shapeCollection.addFigure(shape1);
        shapeCollection.addFigure(shape2);
        shapeCollection.addFigure(shape3);
        //When
        shapeCollection.removeFigure(shape1);
        shapeCollection.removeFigure(shape2);
        shapeCollection.removeFigure(shape3);
        //Then
        Assert.assertEquals(0,shapeCollection.showFigures());

    }
    //Test 3: sprawdzający, czy odpowiednio pobiera z kolekcji figurę z pozycji n listy
    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape1 = new Square("square",5);
        Shape shape2 = new Triangle("triangle", 5, 3);
        Shape shape3 = new Circle("circle", 5);
        shapeCollection.addFigure(shape1);
        shapeCollection.addFigure(shape2);
        shapeCollection.addFigure(shape3);
        //When
        Shape expectedFigure1 = shapeCollection.getFigure(0);
        Shape expectedFigure2 = shapeCollection.getFigure(1);
        Shape expectedFigure3 = shapeCollection.getFigure(2);
        //Then
        Assert.assertEquals(shape1,expectedFigure1);
        Assert.assertEquals(shape2,expectedFigure2);
        Assert.assertEquals(shape3,expectedFigure3);
    }
    //Test 4: sprawdzający, czy odpowiednio wyświetla figury
    @Test
    public void testShowFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape1 = new Square("square",5);
        Shape shape2 = new Triangle("triangle", 5, 3);
        Shape shape3 = new Circle("circle", 5);
        //When
        shapeCollection.addFigure(shape1);
        shapeCollection.addFigure(shape2);
        shapeCollection.addFigure(shape3);
        //Then
        Assert.assertEquals(shape1,shapeCollection.getFigure(0));
        Assert.assertEquals(shape2,shapeCollection.getFigure(1));
        Assert.assertEquals(shape3,shapeCollection.getFigure(2));
    }
}
