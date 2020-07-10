package com.kodilla.testing.forum;
import com.kodilla.testing.user.SimpleUser;
import org.junit.*;
public class ForumTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testCaseUsername(){
        //Given, dysponujemy obiektem simpleUser klasy SimpleUser, z zainicjowaną nazwą użytkownika
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When, czyli to, co naprawdę chcemy przetestować. Tutaj wywołujemy getter getUsername() i przypisujemy rezultat do zmiennej result, abyśmy mogli wykonać odpowiednie sprawdzenia w następnych liniach.
        String result = simpleUser.getUsername();
        System.out.println("Testing " + result);
        //Then, czyli zestaw warunków, które są sprawdzane w celu stwierdzenia, czy test wykonał się poprawnie. Tutaj akurat wykorzystujemy do tego metodę statyczną assertEquals(String expected; String actual) klasy Assert. Metoda ta zgłosi błąd, gdy porównywane wartości — oczekiwana (ang. expected) oraz aktualna (ang. actual) — będą różne.
        Assert.assertEquals("theForumUser", result);
    }
    @Test
    public void testCaseRealName(){
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals("John Smith", result);
    }
}
