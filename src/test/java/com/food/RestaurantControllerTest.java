package com.food;

import com.food.resturantService.Item;
import com.food.resturantService.Restaurant;
import com.food.resturantService.RestaurantController;
import com.food.resturantService.RestaurantServiceInterface;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ab06083 on 1/24/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantControllerTest {

    @InjectMocks
    private RestaurantController restaurantController;

    @Mock
    private RestaurantServiceInterface restaurantServiceInterface;


    @Test
    public void userShouldSeeAllTheAvailableRestaurantName() {
        when(restaurantServiceInterface.getAllRestaurant()).thenReturn(createRestaurantList());
        List<String> restaurantDOs = restaurantController.getAllRestaurant();
        assertEquals(4, restaurantDOs.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void userShouldGetErrorMessageWhenTryToAccessIndexMoreThanTheSizeOfList() {
        getRestaurantByIndex(5);
        verify(restaurantServiceInterface).getAllRestaurant();
    }

    @Test(expected = IllegalArgumentException.class)
    public void userShouldGetErrorMessageWhenTryToAccessIndexEqualToTheSizeOfList()
    {
        getRestaurantByIndex(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void userShouldGetErrorMessageWhenTryToAccessNegativeIndex() {
        getRestaurantByIndex(-3);
    }

    @Test
    public void shouldAbleToAccessRestaurantByIndex() {
        whenConditionForRestaurantRepoCall();

        Restaurant actualResult = restaurantController.getRestaurantByIndex(0);
        verify(restaurantServiceInterface).getRestaurantMenuByIndex(0);
        Assert.assertEquals("BBQ",actualResult.getName());
    }

    @Test
    public void userShouldBeAbleToSeeSelectedRestaurantMenu() {
        whenConditionForRestaurantRepoCall();

        Restaurant actualResult = restaurantController.getRestaurantByIndex(0);
        Item firstItem = actualResult.getItems().get(0);
        Assert.assertEquals("Goat curry",firstItem.getDish());
        Assert.assertEquals(543.50,firstItem.getPrice(),.50);
    }

    private void whenConditionForRestaurantRepoCall() {
        when(restaurantServiceInterface.getRestaurantMenuByIndex(anyInt())).thenReturn(createRestaurantObject());
        when(restaurantServiceInterface.getAllRestaurant()).thenReturn(createRestaurantList());
    }

    private Restaurant createRestaurantObject(){
        Restaurant restaurant = new Restaurant("BBQ");
        List<Item> items = new ArrayList<>();
        items.add(new Item("Goat curry",543.50));
        items.add(new Item("Fish Masala",345.49));
        items.add(new Item("Vegetarian Thali",234.35));
        items.add(new Item("Chicken Tikka Masala",342.54));
        restaurant.setItems(items);
        return restaurant;
    }

    private void getRestaurantByIndex(int index) {
        when(restaurantServiceInterface.getAllRestaurant()).thenReturn(createRestaurantList());
        restaurantController.getRestaurantByIndex(index);
    }

    private List<String> createRestaurantList() {
        List<String> restaurantDOList = new ArrayList<>();
        restaurantDOList.add("BBQ");
        restaurantDOList.add("TGIF");
        restaurantDOList.add("CUBA");
        restaurantDOList.add("QBAR");
        return restaurantDOList;
    }

}