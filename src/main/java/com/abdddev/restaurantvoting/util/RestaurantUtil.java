package com.abdddev.restaurantvoting.util;

import com.abdddev.restaurantvoting.model.Restaurant;
import com.abdddev.restaurantvoting.to.RestaurantTo;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class RestaurantUtil {
    public static List<RestaurantTo> convertToTo(List<Restaurant> restaurantList) {
        return restaurantList.stream()
                .map(RestaurantTo::new)
                .toList();
    }
}
