package com.kodilla.stream.sand;

import java.math.BigDecimal;

//Klasa ta implementuje metodę getSandBeansQuantity(), która ma zwrócić informację o ilości ziaren piasku w Europie
public final class Europe implements SandStorage {
    @Override
    //Inicjalizacja zmiennej typu BigDecimal poprzez tekst reprezentujący dużą liczbę
    public BigDecimal getSandBeansQuantity(){
        BigDecimal sandQuantity = new BigDecimal("12345678901234567890");
        return sandQuantity;
    }
}
