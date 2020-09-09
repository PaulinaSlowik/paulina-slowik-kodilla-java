package com.kodilla.good.patterns.challenges.Food2Door;


public class OrderFoodDto {
    public OrderFood orderFood;
    public boolean isOrdered;

    public OrderFoodDto(final OrderFood orderFood, final boolean isOrdered) {
        this.orderFood = orderFood;
        this.isOrdered = isOrdered;
    }

    public OrderFood getOrderFood() {
        return orderFood;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
