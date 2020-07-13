package com.kodilla.testing.shape;

import org.junit.*;


//Test suite for classes of ShapeCollector
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public class void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public class void afterAllTest(){
        System.out.println("All test are finished.");
    }

    @Before
    public class void beforeEveryTest(){
        testCounter++;
        System.out.println("reparing to execute test #" + testCounter);
    }

    //Test 1: sprawdzający, czy po dodaniu figur do kolekcji liczba figur w kolekcji się zgadza
    @Test
    public void testAddFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape1 = new Square();
        Shape shape2 = new Triangle();
        Shape shape3 = new Circle();
        //When
        shapeCollection.addFigure(shape1);
        shapeCollection.addFigure(shape2);
        shapeCollection.addFigure(shape3);
        //Then
        Assert.assertEquals(3,shapeCollection.getAddFigureQuantity());

    }
    //Test 2: sprawdzający, czy po usunięcie figury lczba figur wynosi 1
    @Test
    public void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape1 = new Square();
        Shape shape2 = new Triangle();
        Shape shape3 = new Circle();
        shapeCollection.addFigure(shape1);
        shapeCollection.addFigure(shape2);
        shapeCollection.addFigure(shape3);
        //When
        shapeCollection.removeFigure(shape1);
        shapeCollection.removeFigure(shape2);
        shapeCollection.removeFigure(shape3);
        //Then
        Assert.assertEquals(0,shapeCollection.getShapeCollection());

    }
    //Test 3: sprawdzający, czy odpowiednio pobiera z kolekcji figurę z pozycji n listy
    @Test
    public void testGetFigure(){
        //Given
        ShapeCollector shapeCollection = new ShapeCollector();
        Shape shape1 = new Square();
        Shape shape2 = new Triangle();
        Shape shape3 = new Circle();
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
        Shape shape1 = new Square();
        Shape shape2 = new Triangle();
        Shape shape3 = new Circle();
        shapeCollection.addFigure(shape1);
        shapeCollection.addFigure(shape2);
        shapeCollection.addFigure(shape3);
        //When
        Shape expectedFigure1 = shapeCollection.showFigures();
        Shape expectedFigure2 = shapeCollection.showFigures();
        Shape expectedFigure3 = shapeCollection.showFigures();
        //Then
        Assert.assertEquals(shape1,expectedFigure1);
        Assert.assertEquals(shape2,expectedFigure2);
        Assert.assertEquals(shape3,expectedFigure3);
    }
}
