package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderFood {
    private Producent producent;
    private String typoOfProducts;
    private int quantityOfProducts;
    private int priceForUnit;

    public OrderFood(Producent producent, String typoOfProducts, int quantityOfProducts, int priceForUnit) {
        this.producent = producent;
        this.typoOfProducts = typoOfProducts;
        this.quantityOfProducts = quantityOfProducts;
        this.priceForUnit = priceForUnit;
    }

    public Producent getProducent() {
        return producent;
    }

    public String getTypoOfProducts() {
        return typoOfProducts;
    }

    public int getQuantityOfProducts() {
        return quantityOfProducts;
    }

    public int getPriceForUnit() {
        return priceForUnit;
    }
}
