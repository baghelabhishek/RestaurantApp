package com.food.resturantService;

import java.util.List;

/**
 * Created by hadoop on 26/01/17.
 */
public interface RestaurantRepoInterface {

     List<String> getAllRestaurantByName();
     Restaurant getRestaurantMenuByIndex(int index);

}
