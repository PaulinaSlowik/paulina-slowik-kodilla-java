package com.kodilla.testing.user;
public class SimpleUser { //klasa ta reprezentuje użytkownika
    String username;
    String realName;
    public SimpleUser(String username, String realName) { //konstruktor który jako argument przyjmuje nazwę użytkownika
        this.username = username;
        this.realName = realName;
    }
    public String getUsername() { //geter typu String zwracający nazwę użytkownika
        return username;
    }
    public String getRealName() {
        return realName;
    }
}
