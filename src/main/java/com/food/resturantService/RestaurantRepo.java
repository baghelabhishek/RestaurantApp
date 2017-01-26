package com.food.resturantService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ab06083 on 1/9/2017.
 */
public class RestaurantRepo  {

    public List<String> getAllRestaurantByName() {

        List<String> allRestaurant = new ArrayList<>();
        allRestaurant.add("BBQ");
        allRestaurant.add("PH");
        allRestaurant.add("QBAR");
        allRestaurant.add("WTF");
        return allRestaurant;
    }

    public Restaurant getRestaurantMenuByIndex(int index){
        Restaurant restaurant = new Restaurant("BBQ");
        return restaurant;
    }
}
