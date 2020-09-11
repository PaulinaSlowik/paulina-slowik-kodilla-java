package com.kodilla.good.patterns.challenges.Food2Door;

//odpowiedzialność klasy: obsługa serwisu zamawiającego produkty od różnych producentów
public class OrderingFoodProcessor {
    //interfejsy reprezentujące utworzone serwisy
    private InformationFoodService informationFoodService;
    private OrderFoodService orderFoodService;

    public OrderingFoodProcessor(final InformationFoodService informationFoodService,
                                 final OrderFoodService orderFoodService) {
        this.informationFoodService = informationFoodService;
        this.orderFoodService = orderFoodService;
    }

    public OrderFoodDto process(OrderFood orderFood) {
        boolean isOrdered = orderFoodService.order(orderFood.getProducent(), orderFood.getTypoOfProducts(), orderFood.getQuantityOfProducts());

        if (isOrdered) {
            informationFoodService.inform(orderFood.getProducent(), orderFood);
            return new OrderFoodDto(orderFood, true);
        } else {
            return new OrderFoodDto(orderFood, false);
        }
    }
}
