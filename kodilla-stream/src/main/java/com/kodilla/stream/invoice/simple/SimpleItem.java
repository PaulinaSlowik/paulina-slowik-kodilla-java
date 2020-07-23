package com.kodilla.stream.invoice.simple;

public class SimpleItem {
    private final SimpleProduct product;
    private final double quantity;

    public SimpleItem(SimpleProduct product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public SimpleProduct getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    //metoda getValue() obliczająca wartość pozycji na fakturze.
    //Znajduje się w niej operacja mnożenia, która za chwilę przysporzy nam nieco problemów, obrazujących ogólny problem z typami zmiennoprzecinkowymi
    public double getValue() {
        return product.getProductPrice() * quantity;
    }
}
