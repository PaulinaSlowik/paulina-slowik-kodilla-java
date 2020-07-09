package com.kodilla.testing;

public class SimpleUser { //klasa ta reprezentuje użytkownika
    private String username;

    public SimpleUser(String username) { //konstruktor który jako argument przyjmuje nazwę użytkownika
        this.username = username;
    }

    public String getUsername() { //geter typu String zwracający nazwę użytkownika
        return username;
    }
}
