package OrderService;

import com.food.resturantService.Restaurant;
import com.food.resturantService.RestaurantController;

/**
 * Created by hadoop on 26/01/17.
 */
public class OrderController {

    private RestaurantController restaurantController;

    public OrderController(RestaurantController restaurantController) {
        this.restaurantController = restaurantController;
    }

    public void orderFood(int itemNuber) {
        Restaurant restaurant = restaurantController.getMenuOfRestaurantByIndex(itemNuber);
        if (restaurant.getItems().size() < itemNuber)
            throw new IllegalArgumentException();

    }
}
