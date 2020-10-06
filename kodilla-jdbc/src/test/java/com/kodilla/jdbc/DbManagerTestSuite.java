package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testSelectUsersAndPosts() throws SQLException{
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER\n" +
                "FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY P.USER_ID\n" +
                "HAVING COUNT(*) > 1\n" +
                "ORDER BY U.LASTNAME, U.FIRSTNAME";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getInt("POSTS_NUMBER"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(1, counter);
    }

    @Test
    public void testConnection() throws SQLException {
        //Given
        //When
        //test wywołuje metodę getInstance() klasy DbManager, która to metoda nawiązuje połączenie z bazą danych
        DbManager dbManager = DbManager.getInstance();
        //Then
        //przy pomocy asercji, sprawdzamy czy połączenie zostało nawiązane
        Assert.assertNotNull(dbManager.getConnection());
    }

    //Spróbujemy odczytać z bazy danych zawartość tabeli USERS
    @Test
    public void testSelectUsers() throws SQLException{
        //Given
        //Nawiązanie połączenia z bazą danych
        DbManager dbManager = DbManager.getInstance();
        //When
        //String z treścią zapytania
        String sqlQuery = "SELECT * FROM USERS";
        //tworzymy obiekt implementujący interfejs Statement, dostarczany przez bibliotekę java.sql
        //Obiekt ten jest tworzony przez metodę createStatement() klasy Connection.
        //Statement możemy sobie wyobrażać jako zapytanie
        Statement statement = dbManager.getConnection().createStatement();
        //Zapytanie możemy otworzyć poprzez wywołanie jego metody executeQuery(String query) -
        //jako argument wywołania należy podać String z treścią zapytania
        //Metoda executeQuery(String query) zwraca kolekcję danych typu ResultSet
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        //iterujemy po kolekcji danych typu ResultSet przy pomocy metody next()
        //Początkowo, ResultSet posiada "kursor" ustawiony przed pierwszym elementem
        int counter = 0;
        //Wywołanie metody next() powoduje przesunięcie "kursora" na następny element
        //Metoda ta zwraca true, gdy udało się pobrać następny rekord, czyli dopóki jest po czym iterować
        while(rs.next()) {
            //Obiekt klasy ResultSet udostępnia szereg metod pozwalających na pobranie danych z pól rekordu, na którym jesteśmy aktualnie ustawieni
            //Do pobrania danych używamy np. metod getInt(String fieldName), getString(String fieldName) oraz innych - zależnych od typu kolumny w bazie danych
            //wykorzystujemy te metody do odczytania wartości pól z tabeli USERS: ID, FIRSTNAME oraz LASTNAME, które następnie poglądowo wyświetlamy zawartość rekordów w oknie konsoli. Ponadto, zliczamy też ilość odczytanych rekordów.
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        //Obiekty typu ResultSet oraz Statement należy "zamykać" po ich użyciu przy pomocy metody close()
        // Spowoduje to zwolnienie zasobów użytych do ich utworzenia już podczas działania programu, a nie po jego zakończeniu
        rs.close();
        statement.close();
        //sprawdzamy czy ilość rekordów odczytanych z bazy danych jest zgodna z ilością rekordów w tabeli USERS
        Assert.assertEquals(5, counter);
    }
}
