package com.kodilla.exception.nullpointer;

//Zauważ, że klasę wyjątku MessageNotSentException odziedziczyliśmy po klasie Exception - dzięki temu, nasz wyjątek jest checked i jego obsłużenie jest wymagane
public class MessageNotSentException extends Exception {
    //stworzyliśmy konstruktor w którym możemy przekazać wiadomość jaką będzie przechowywać ten błąd dla innego programisty
    public MessageNotSentException(final String message) {
        super(message);
    }
}
