package com.kodilla.good.patterns.challenges.Allegro;

public class User {
    private final String username;
    private final String name;
    private final String surname;
    private final String email;
    private final String address;

    public User(String username, String name, String surname, String email, String address) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}