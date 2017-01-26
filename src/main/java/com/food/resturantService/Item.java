package com.food.resturantService;

/**
 * Created by ab06083 on 1/23/2017.
 */
public class Item {

    private String dish;
    private double price;

    public String getDish() {
        return dish;
    }

    public double getPrice() {
        return price;
    }

    public Item(String dish, double price) {
        this.dish = dish;
        this.price = price;
    }
}
