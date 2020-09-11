package com.kodilla.good.patterns.challenges.Food2Door;

public class ApplicationFood2Door {

    public static void main(String[] args) {
        OrderFoodRetriever orderFoodRequestRetriever = new OrderFoodRetriever();
        OrderFood orderFoodRequest = orderFoodRequestRetriever.retrieve();

        OrderingFoodProcessor orderingFoodProcessor = new OrderingFoodProcessor
                (new ProductInformationFoodService(), new ProductOrderFoodService());
        orderingFoodProcessor.process(orderFoodRequest);
    }
}