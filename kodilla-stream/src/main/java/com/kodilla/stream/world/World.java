package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> listOfContinent = new ArrayList<>();

    public void addListOfContinent(Continent continent){
        listOfContinent.add(continent);
    }

    public boolean removeListOfContinent(Continent continent){
        return listOfContinent.remove(continent);
    }

    public List<Continent> getListOfContinent() {
        return listOfContinent;
    }

    public BigDecimal getPeopleQuantity(){
        return (BigDecimal) listOfContinent.stream()
                //dokonuje spłaszczenia strumienia- dla każdego kontynentu (continent) pobieram jego listę krajów (continent.getListOfCountry()) i ją przekazuje do dalszego przetwarzania w postaci nowego strumienia Stream.
                //Od tego momentu pracuje nie na liście krajów, lecz na liście "krajów krajów".
                .flatMap(continent -> continent.getListOfCountry().stream())
                //transformuje strumień tak, że zamiast obiektów Country, dalej będą już przez niego przepływały jedynie obiekty BigDecimal(liczby typu BigDecimal) będące ilością ludzi w poszczególnych krajach (pobieram je przy pomocy metody Country::getPeopleQuantity)
                .map(Country::getPeopleQuantity)
                //dokonanie obliczenia (suma elementów)i zwrócenie pojedynczeo wyniku obliczen zamiast np. kolekcj za pomocą operacji terminalnej reduce(identity, BinaryOperator accumulator)
                //wartość początkowa (identity),dwuargumentową funkcja accumulator obliczająca wartość końcową, której pierwszy argument stanowi dotychczas obliczona wartość pośrednia, a drugi bieżąca wartość obiektu ze strumienia
                //wartość początkowa to BigDecimal.ZERO a potem dla każdej liczby w kolkcji wykonuje wyrażenie lambda (sum, current) -> sum = sum.add(current)
                //sum jest wynikiem pośrednim uzyskanym dla poprzedniego obiektu w kolekcji (na początku przy pierwszym elemencie jest to BigDecimal.ZERO, czyli wartość początkowa identity)
                //Wyrażenie lambda przypisuje do zmiennej sum nową wartość będącą sumą dotychczasowych obliczeń i wartości current (bieżący obiekt w strumieniu)
                //Po dokonaniu obliczenia - wartość ta będzie przekazana do "następnego przebiegu" kolektora jako nowa wartość pośrednia.

                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

                //inne wytłumaczenie: reduce przyjmuje dwa argumenty, pierwszy to z jakiego zaczynamy zakresu czyli zero a drugi przyjmuje już zsumowaną wartość plus aktualną wartość którą wyciąga ze strumienia
                //czyli np. jest strumień elementów 1,2,3,4,5 to dla pierwszego elementu (pierwsza iteracja) suma wynosi zero(bo nie ma sumy) więc 0+1=1, dla drugiego elementu suma wynosi 1 a current element jest 2 więc 1+2=3, dla trzeciego elementu suma wynosi 3 a current element to 3 czyli 3+3=6, dla czwartego elementu suma wynosi 6 a current elementu to 4 czyli 6+4=10
    }
}
