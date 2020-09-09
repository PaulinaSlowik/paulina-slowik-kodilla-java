package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderFoodRetriever {

    public OrderFood retrieve() {

        Producent extraFoodShop = new ExtraFoodShop(6);
        OrderFood extraFoodShopOrder = new OrderFood(extraFoodShop,"banana",6,20);
        return extraFoodShopOrder;
        //lub return new OrderFood(extraFoodShop,"banana",6,20);
    }
}
