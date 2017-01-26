package OrderService;

import com.food.resturantService.Item;
import com.food.resturantService.Restaurant;
import com.food.resturantService.RestaurantController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by hadoop on 26/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @Mock
    private RestaurantController restaurantController;

    @InjectMocks
    private OrderController orderService;


    @Test
    public void orderShouldGetTheRestaurantMenu() {
        orderService.orderFood(2);
        verify(restaurantController).getMenuOfRestaurantByIndex(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetErrorWhenOrderIndexIsGreaterThanSizeOfMenuItem() {
        when(restaurantController.getMenuOfRestaurantByIndex(anyInt())).thenReturn(getAnyRestaurant());
        getAnyRestaurant().getItems().size();
        orderService.orderFood(4);

    }

    private Restaurant getAnyRestaurant() {
        Restaurant restaurant = new Restaurant("anyRestaurant");
        restaurant.setItems(createItemList());
        return  restaurant;
    }

    private List<Item> createItemList() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Goat curry",543.50));
        items.add(new Item("Fish Masala",345.49));
        items.add(new Item("Vegetarian Thali",234.35));
        return items;
    }
}