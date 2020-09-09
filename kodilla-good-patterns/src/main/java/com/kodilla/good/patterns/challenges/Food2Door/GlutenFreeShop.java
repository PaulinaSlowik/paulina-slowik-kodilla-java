package com.kodilla.good.patterns.challenges.Food2Door;

public class GlutenFreeShop implements Producent{

    private double rateOfMoreFreshFood;

    public GlutenFreeShop(double rateOfMoreFreshFood) {
        this.rateOfMoreFreshFood = rateOfMoreFreshFood;
    }

    public double getMoreFreshFood() {
        return rateOfMoreFreshFood;
    }

    @Override
    public boolean process(OrderFood orderFood) {
        double moreFreshFoodPayment = (orderFood.getQuantityOfProducts()*orderFood.getPriceForUnit())+(orderFood.getPriceForUnit()*rateOfMoreFreshFood);
        double standardPayment = (orderFood.getQuantityOfProducts()*orderFood.getPriceForUnit());
        System.out.println("GlutenFreeShop, you have ordered: ");
        if (orderFood.getPriceForUnit() > 50) {
            System.out.println("Payment with more fresh food equals: " + moreFreshFoodPayment);
        } else {
            System.out.println("Standard payment of: " + standardPayment);
        }
        return true;
    }
}
