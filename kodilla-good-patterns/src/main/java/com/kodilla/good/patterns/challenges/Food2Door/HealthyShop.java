package com.kodilla.good.patterns.challenges.Food2Door;

public class HealthyShop implements Producent{

    private double productForFree;

    public HealthyShop(double productForFree) {
        this.productForFree = productForFree;
    }

    public double getGproductForFree() {
        return productForFree;
    }

    @Override
    public boolean process(OrderFood orderFood) {
        double oneProductForFree = (orderFood.getQuantityOfProducts())+productForFree;
        System.out.println("HealthyShop, you have ordered: ");
        if (orderFood.getQuantityOfProducts() > 30) {
            System.out.println("One product for free. The sum of products are: " + oneProductForFree);
        } else {
            System.out.println("You have no free product, quantity is too small.");
        }
        return false;
    }
}
