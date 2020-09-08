package com.kodilla.good.patterns.challenges.Allegro;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User ("JohnW","John", "Wekl", "john.wekl@gmail.com","Garden Street 124 London");
        Product product = new Product ("Game","Pokemon",2,50);

        return new OrderRequest(user,product);
    }
}
