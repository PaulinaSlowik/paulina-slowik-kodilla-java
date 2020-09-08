package com.kodilla.good.patterns.challenges.Allegro;

public class ProductOrderService implements OrderService{
    public boolean order (User user, Product product) {
        System.out.println("Order product category " + product.getProductCategory() +
                ", name: " + product.getProductName() + ", quantity of product: " +
                product.getQuantity() + " and price: " + product.getPrice() +
                " has been ordered by " + user.getUsername() + " with contact details: " +
                user.getName() +" "+ user.getSurname() +" "+ user.getEmail() +" "+ user.getAddress());
    return  true;
    }
}
