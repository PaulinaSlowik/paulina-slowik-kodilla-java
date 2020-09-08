package com.kodilla.good.patterns.challenges.Allegro;

public class EmailService implements InformationService{
    public void inform(User user){
        System.out.println("E-mail has been sent to: " + user.getUsername() + " " + user.getName() + " "+ user.getSurname());
    }

}
