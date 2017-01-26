package com.food;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ab06083 on 1/10/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceTest {
    @InjectMocks
    private RestaurantService restaurantService;
    @Mock
    private RestaurantRepo restaurantRepo;

    @Test
    public void returnRestaurantListWithZeroSizeWhenThereISNoDataInRepo()  {
        when(restaurantRepo.getAllRestaurantByName()).thenReturn(new ArrayList<String>());
        List<String> actualResult = restaurantService.getAllRestaurant();
        Assert.assertEquals(new ArrayList(),actualResult);
    }

    @Test
    public void returnAllTheRestaurantNameWhichAreAvailableInRepo() {
        List<String> restaurantDOs = new ArrayList<>();
        restaurantDOs.add("BBQ");
        restaurantDOs.add("HRC");
        restaurantDOs.add("WTF");
        when(restaurantRepo.getAllRestaurantByName()).thenReturn(restaurantDOs);
        List<String> actualResult = restaurantService.getAllRestaurant();
        Assert.assertEquals(3,actualResult.size());
    }

    @Test
    public void shouldReturnRestaurantObjectByIndex() {
        when(restaurantRepo.getRestaurantMenuByIndex(anyInt())).thenReturn(new Restaurant("HRC"));
        Restaurant restaurantDO = restaurantService.getRestaurantMenuByIndex(0);
        verify(restaurantRepo).getRestaurantMenuByIndex(0);
        Assert.assertEquals("HRC",restaurantDO.getName());
    }
}