package com.food;

import java.util.List;

/**
 * Created by ab06083 on 1/10/2017.
 */
public class RestaurantService implements RestaurantServiceInterface {

    private RestaurantRepo restaurantRepo;

    public RestaurantService(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    public List<String> getAllRestaurant() {
        return restaurantRepo.getAllRestaurantByName();
    }

    public Restaurant getRestaurantMenuByIndex(int index) {
        return restaurantRepo.getRestaurantMenuByIndex(index);
    }



}
