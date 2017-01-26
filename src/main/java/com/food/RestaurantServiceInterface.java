package com.food;

import java.util.List;

/**
 * Created by ab06083 on 1/24/2017.
 */
public interface RestaurantServiceInterface {

    public List<String> getAllRestaurant();

    public Restaurant getRestaurantMenuByIndex(int index);
}
