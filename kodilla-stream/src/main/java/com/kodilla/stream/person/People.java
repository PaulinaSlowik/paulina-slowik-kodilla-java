package com.kodilla.stream.person;

import java.util.ArrayList;
import java.util.List;

public class People {
    //metoda statyczna getList(), która tworzy przykładową listę imion i nazwisk osób a potem tę listę zwraca
    public static List<String> getList() {
        //zmienna theList oznaczona jest jako final,aby zapobiec przypadkowym modyfikacją póżniej(przypisanie innej listy do zmiennej)
        //zmienna theList jest typu List a nie ArrayList bo typowanie zmiennych przechowujących kolekcje najlepiej jest robć poprzez typ interfejsu a nie typ konkretnej klasy implementującej interfejs(taki sposób typowania jest bardziej elastyczny bo mozna do takiej zmiennej przypisać w programie również inne implementacje list np. LinkedList)
        //na końcu przy ArrayList są puste nawiasy <>, można tak skrócić zapis jeżeli z typu zmiennej wynika jakiego typu obiekty będą w kolekcji(umieszczone przy typie zmiennej)
        final List<String> theList = new ArrayList<>();
        theList.add("John Smith");
        theList.add("Dorothy Newman");
        theList.add("John Wolkowitz");
        theList.add("Lucy Riley");
        theList.add("Owen Rogers");
        theList.add("Matilda Davies");
        theList.add("Declan Booth");
        theList.add("Corinne Foster");
        theList.add("Khloe fry");
        theList.add("Martin Valenzuela");
        //zwracamy NIE listę przechowującą w zmiennej theList ale tworzymy jej kopię (tworzymy nową listę przy pomocy konstruktora kopiującego)- jest to rozwiązanie zapobiegające mutowaniu obiektów
        //ponieważ operacja modyfikacji zostanie wykonana na kopii obiektu theList a nie na samym obiekcie więc nawet gdy "konsument" wyników działania metody getList() zmieni coś w otrzymanej kolkcji to nie spowoduje to zmiany obiektów wewnątrz klasy People
        return new ArrayList<String>(theList);
    }
}
