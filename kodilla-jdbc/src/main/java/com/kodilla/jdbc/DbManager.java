package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
    //pole conn typu Connection przechowujące referencję do obiektu reprezentującego połączenie do bazy danych.
    //Connection jest interfejsem dostarczanym przez bibliotekę java.sql.
    //Interfejs Connection udostępnia szereg metod związanych z zadawaniem zapytań do bazy danych oraz obsługą połączenia.
    private Connection conn;
    //pole dbManagerInstance, które przechowuje referencję do instancji klasy DbManager
    //potrzebne jest nam ono po to, aby w pamięci komputera dostępna była zawsze tylko jedna instancja obiektu klasy DbManager (wzorzec Singleton)
    //
    private static DbManager dbManagerInstance;

    //definicja konstruktora klasy DbManager
    //Konstruktor jest prywatny - nie ma możliwości wywołania go spoza metod klasy DbManager
    private DbManager() throws SQLException {
        //tworzymy obiekt klasy Properties (dostarczanej przez bibliotekę java.util). Klasa Properties jest bardzo podobna do kolekcji HashMap - przechowuje pary wartości key-value (klucz-wartość)
        //Przydatną cechą obiektów tej klasy jest możliwość zapisywania i odczytywania wartości właściwości z plików .properties.
        Properties connectionProps = new Properties();
        //ustawiają wartość właściwości user oraz password
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_password");
        //tworzymy połączenie do bazy danych przy pomocy statycznej metody getConnection(String url, Properties info) klasy DriverManager dostarczanej przez bibliotekę java.sql.
        //Pierwszy parametr tej metody (url) to tak zwany "connection string"
        //Drugi z parametrów - info to obiekt typu Properties. Obiekt ten w najprostszej, używanej przez nas, postaci zawiera nazwę i hasło użytkownika
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
    }

    //metoda getInstance() klasy DbManager, która nawiązuje połączenie z bazą danych
    //metoda ta tworzy (w razie potrzeby - gdy nie był wcześniej utworzony) i udostępnia obiekt klasy DbManager
    //podejście lazy instantiating, czyli metoda ta tworzy obiekt dopiero wtedy gdy jest on potrzebny (czyli przy pierwszym wywołaniu tej metody)
    //klasa DbManager sama zarządza powoływaniem do życia swojej instancji, przy pomocy metody getInstance(),zgodnie ze wzorcem Singleton
    public static DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    //metody getConnection(), która zwraca obiekt klasy Connection, czyli obiekt przechowujący połączenie z bazą danych -
    //będziemy używali go do tworzenia zapytań do bazy danych
    public Connection getConnection() {
        return conn;
    }
}
