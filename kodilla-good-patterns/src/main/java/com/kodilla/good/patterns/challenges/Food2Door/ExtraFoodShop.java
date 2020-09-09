package com.kodilla.good.patterns.challenges.Food2Door;

public class ExtraFoodShop implements Producent{

    private double bonusDiscount;

    public ExtraFoodShop(double bonusDiscount) {
        this.bonusDiscount = bonusDiscount;
    }

    public double getBonusDiscount() {
        return bonusDiscount;
    }

    public boolean process (OrderFood orderFood) {
        double bonusPayment = (orderFood.getQuantityOfProducts()*orderFood.getPriceForUnit())-bonusDiscount;
        double standardPayment = (orderFood.getQuantityOfProducts()*orderFood.getPriceForUnit());
        System.out.println("ExtraFoodShop, you have ordered: ");
        if (orderFood.getQuantityOfProducts() >5) {
            System.out.println("Payment with discount of " + getBonusDiscount() + " and equals " + bonusPayment);
        }else{
            System.out.println("Standard payment of: " + standardPayment);
        }
    return true;
    }
}
