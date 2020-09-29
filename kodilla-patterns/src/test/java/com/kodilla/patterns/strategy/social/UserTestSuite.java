package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    //czy domyślnie utworzone obiekty generujące wpisy w mediach społecznościowych są poprawne
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User anna = new Millenials("anna");
        User david = new YGeneration("david");
        User john = new ZGeneration("john");
        //When
        String annaComunicator = anna.sharePost();
        System.out.println("Anna's comunicator is: " +annaComunicator);
        String davidComunicator = david.sharePost();
        System.out.println("David's comunicator is: " +davidComunicator);
        String johnComunicator = john.sharePost();
        System.out.println("John's comunicator is: " +johnComunicator);
        //Then
        Assert.assertEquals("Facebook", annaComunicator);
        Assert.assertEquals("Twitter", davidComunicator);
        Assert.assertEquals("Snapchat", johnComunicator);
    }

    //czy możliwa jest indywidualna zmiana upodobań użytkownika
    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User anna = new Millenials("anna");
        //When
        String annaComunicator = anna.sharePost();
        System.out.println("Anna's comunicator is: " +annaComunicator);
        anna.setSocialPublisher(new TwitterPublisher());
        annaComunicator = anna.sharePost();
        System.out.println("Anna's comunicator is: " +annaComunicator);
        //Then
        Assert.assertEquals("Twitter", annaComunicator);
    }
}