package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");//program tworzy obiekt simpleUser klasy SimpleUser, podając jako argument konstruktora nazwę użytkownika "theForumUser"

        String result = simpleUser.getUsername();//do zmiennej result przypisuje efekt wywołania gettera getUsername utworzonego obiektu.Przy pomocy gettera getUsername pobiera zapamiętaną nazwę użytkownika i porówna ją z nazwą użytkownika użytą w kontruktorze
        if (result.equals("theForumUser")){//Jeżeli nazwy są takie same, wówczas test uznajemy za wykonany poprawnie. W przeciwnym wypadku przyjmujemy, że wystąpił błąd w klasie SimpleUser.
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // Testing Calculator class
        Calculator calculator = new Calculator();
        int addResult = calculator.add(180, 19);
        int subResult = calculator.subtract(200, 150);
        if ((addResult == 199) && (subResult == 50)) {
            System.out.println("Calculator test OK");
        } else {
            System.out.println("Calculator has error!");
        }
    }
}
