package com.food.resturantService;

import java.util.List;

/**
 * Created by ab06083 on 1/10/2017.
 */
public class Restaurant {

    private String name;
    private List<Item> items;

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public Restaurant(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }
}
