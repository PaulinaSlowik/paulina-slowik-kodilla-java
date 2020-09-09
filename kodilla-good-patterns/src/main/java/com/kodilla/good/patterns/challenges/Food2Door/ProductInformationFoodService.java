package com.kodilla.good.patterns.challenges.Food2Door;

public class ProductInformationFoodService implements InformationFoodService{
    public void inform(Producent producent, OrderFood orderFood){
        if(producent.process(orderFood)) {
            System.out.println("Order has been completed!");
        } else {
            System.out.println("Order has been rejected");
        }
    }
}
