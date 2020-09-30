package com.kodilla.patterns.factory.tasks;

public interface Task {
    //metoda wykonująca zadanie
    void executeTask();
    //metoda zwracająca nazwę zadania do wykonania
    String getTaskName();
    //metoda zwracająca true() lub false(), w zależności od tego czy zadanie jest już wykonane czy nie
    boolean isTaskExecuted();
}
