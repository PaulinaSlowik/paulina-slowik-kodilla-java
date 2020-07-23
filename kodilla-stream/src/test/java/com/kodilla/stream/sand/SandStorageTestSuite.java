package com.kodilla.stream.sand;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SandStorageTestSuite {
    @Test
    public void testGetSandBeansQuantity() {
        //Given
        //Test tworzy kolekcję kontynentów (tu: obiektów klas implementujących interfejs SandStorage)
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        //tworzona jest zmienna totalSand typu BigDecimal.
        //Zmienna ta inicjowana jest wartością BigDecimal.ZERO. Użycie stałej statycznej BigDecimal.ZERO zwraca obiekt typu BigDecimal zainicjowany wartością zero.Każde kolejne przypisanie do zmiennej totalSand i tak tworzy nowy obiekt, możemy więc pozostawić taki właśnie zapis (jest to działanie prawie identyczne jak typu String, który również jest niemutowalny).
        //Moglibyśmy również napisać:
        //BigDecimal totalSand = new BigDecimal("0");
        BigDecimal totalSand = BigDecimal.ZERO;
        //przy użyciu pętli for-each obliczana jest suma ilości ziaren piasku na wszystkich kontynentach w kolekcji
        for(SandStorage continent : continents){
            totalSand = totalSand.add(continent.getSandBeansQuantity());
        }

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        //wartość obliczonej sumy porównywana jest z wartością oczekiwaną, obliczoną wcześniej "ręcznie" przez autora kodu
        Assert.assertEquals(expectedSand, totalSand);
    }
    @Test
    public void testGetSandBeansQuantityWithReduce() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //?????????????????????????????????????????????????????????????
        //When
        //uruchamiamy strumień na kolekcji continents, wynik jego działania przypiszemy do zmiennej totalSand typu BigDecimal
        BigDecimal totalSand = continents.stream()
                //???????????????poniższa linia zmienia obiekty w strumieniu z klas reprezentujących kontynenty na liczby typu BigDecimal odpowiadające ilościom ziaren piasku na poszczególnych kontynentach
                .map(SandStorage::getSandBeansQuantity)
                //wywołujemy kolektor skalarny reduce( identity, BinaryOperator accumulator), który jako wartość początkową otrzymuje BigDecimal.ZERO,
                //a następnie dla każdej liczby w kolekcji wykonuje wyrażenie lambda (sum, current) -> sum = sum.add(current),
                //gdzie sum jest wynikiem pośrednim uzyskanym dla poprzedniego obiektu w kolekcji (na początku przy pierwszym elemencie jest to BigDecimal.ZERO, czyli wartość początkowa identity).
                //Wyrażenie lambda przypisuje do zmiennej sum nową wartość będącą sumą dotychczasowych obliczeń i wartości current, reprezentującej bieżący obiekt w strumieniu.
                //Po dokonaniu obliczenia - wartość ta będzie przekazana do "następnego przebiegu" kolektora jako nowa wartość pośrednia.
                //Na końcu - po zakończeniu działania kolektora - obliczona suma jest zwracana do zmiennej totalSand.
                //Operacja reduce( identity, BinaryOperator accumulator) jest bardzo elastyczna. Argument accumulator może być wyrażeniem lambda lub referencją do dwuargumentowej metody dowolnej klasy
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        Assert.assertEquals(expectedSand, totalSand);
    }
}