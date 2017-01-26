package com.food.resturantService;

import java.util.List;

/**
 * Created by ab06083 on 1/10/2017.
 */
public class RestaurantController {

    private RestaurantServiceInterface restaurantServiceInterface;

    public RestaurantController(RestaurantServiceInterface restaurantServiceInterface) {
        this.restaurantServiceInterface = restaurantServiceInterface;
    }

    public List<String> getAllRestaurant() {
        List<String> allRestaurant = restaurantServiceInterface.getAllRestaurant();
        allRestaurant.stream()
                .forEach(System.out::println);
        return allRestaurant;
    }

    public Restaurant getRestaurantByIndex(int index) {
        List<String> allRestaurant = restaurantServiceInterface.getAllRestaurant();
        if (indexIsLessSizeOfListOrGreaterThanZero(index, allRestaurant))
            throw new IllegalArgumentException();
        return restaurantServiceInterface.getRestaurantMenuByIndex(index);
    }

    private boolean indexIsLessSizeOfListOrGreaterThanZero(int index, List<String> allRestaurant) {
        return allRestaurant.size() <= index || index < 0;
    }
}
