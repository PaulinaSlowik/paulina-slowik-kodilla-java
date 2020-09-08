package com.kodilla.good.patterns.challenges.Allegro;

public class Product {
    private String productCategory;
    private String productName;
    private int quantity;
    private int price;

    public Product(String productCategory, String productName, int quantity, int price) {
        this.productCategory = productCategory;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
