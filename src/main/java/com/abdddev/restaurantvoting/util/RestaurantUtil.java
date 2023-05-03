package com.abdddev.restaurantvoting.util;

import com.abdddev.restaurantvoting.model.Restaurant;
import com.abdddev.restaurantvoting.to.RestaurantTo;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class RestaurantUtil {
    public static List<RestaurantTo> convertToTo(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(RestaurantTo::new)
                .toList();
    }

    public static RestaurantTo convertToTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant);
    }
}