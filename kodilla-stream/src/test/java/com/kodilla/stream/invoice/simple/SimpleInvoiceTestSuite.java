package com.kodilla.stream.invoice.simple;

import org.junit.Assert;
import org.junit.Test;

public class SimpleInvoiceTestSuite {
    @Test
    public void testGetValueToPay() {
        //Given
        SimpleInvoice invoice = new SimpleInvoice();
        //When
        //Dla asercji operujących na liczbach zmiennoprzecinkowych podaje się również trzeci parametr delta określający dopuszczalny błąd,
        //czyli maksymalną różnicę pomiędzy oczekiwanym wynikiem (parametr expected) a wartością aktualną (parametr actual).
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 17.28), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 11.99), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",  6.49), 5.0));
        //Then
        Assert.assertEquals(108.975, invoice.getValueToPay(), 0.001);
    }
}
