package com.kodilla.stream.invoice.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleInvoice {
    private final List<SimpleItem> items = new ArrayList<>();

    public void addItem(SimpleItem item) {
        items.add(item);
    }

    public boolean removeItem(SimpleItem item) {
        return items.remove(item);
    }

    public double getValueToPay() {
        return items.stream()
                //nowy rodzaj kolektora: Collectors.summingDouble(ToDoubleFunction mapper), gdzie mapper jest funkcją zwracającą wartości typu double do zsumowania,
                //a sam kolektor oblicza sumę obiektów w strumieniu i zwraca wartość typu double
                .collect(Collectors.summingDouble(SimpleItem::getValue));
    }
}
