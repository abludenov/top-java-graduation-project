package com.abdddev.restaurantvoting.web.dish;

import com.abdddev.restaurantvoting.model.Dish;
import com.abdddev.restaurantvoting.web.MatcherFactory;

import java.time.LocalDate;
import java.util.List;

import static com.abdddev.restaurantvoting.web.restaurant.RestaurantTestData.RESTAURANT_1;

public class DishTestData {
    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Dish.class, "restaurant");

    public static final int DISH1_ID = 1;

    public static final Dish DISH_1 = new Dish(DISH1_ID, "Dish1_Restaurant1", LocalDate.now(), 11.0);
    public static final Dish DISH_2 = new Dish(DISH1_ID + 1, "Dish2_Restaurant1", LocalDate.now(), 21.0);
    public static final Dish DISH_3 = new Dish(DISH1_ID + 2, "Dish3_Restaurant1", LocalDate.now(), 31.0);
    public static final Dish DISH_4 = new Dish(DISH1_ID + 3, "Dish4_Restaurant1", LocalDate.now(), 41.0);

    public static final Dish DISH_5 = new Dish(DISH1_ID + 4, "Dish1_Restaurant2", LocalDate.now(), 12.0);
    public static final Dish DISH_6 = new Dish(DISH1_ID + 5, "Dish2_Restaurant2", LocalDate.now(), 22.0);
    public static final Dish DISH_7 = new Dish(DISH1_ID + 6, "Dish3_Restaurant2", LocalDate.now(), 32.0);
    public static final Dish DISH_8 = new Dish(DISH1_ID + 7, "Dish4_Restaurant2", LocalDate.now(), 42.0);

    public static final Dish DISH_9 = new Dish(DISH1_ID + 8, "Dish1_Restaurant3", LocalDate.now(), 13.0);
    public static final Dish DISH_10 = new Dish(DISH1_ID + 9, "Dish2_Restaurant3", LocalDate.now(), 23.0);
    public static final Dish DISH_11 = new Dish(DISH1_ID + 10, "Dish3_Restaurant3", LocalDate.now(), 33.0);
    public static final Dish DISH_12 = new Dish(DISH1_ID + 11, "Dish4_Restaurant3", LocalDate.now(), 43.0);

    public static final List<Dish> DISHES = List.of(DISH_1, DISH_2, DISH_3, DISH_4);
    public static final List<Dish> DISHES2 = List.of(DISH_5, DISH_6, DISH_7, DISH_8);
    public static final List<Dish> DISHES3 = List.of(DISH_9, DISH_10, DISH_11, DISH_12);

    public static Dish getNew() {
        return new Dish(null, "NewDish", LocalDate.now(), 1.0);
    }

    public static Dish getUpdated() {
        return new Dish(DISH1_ID, "UpdateDish", LocalDate.now(),120.0,  RESTAURANT_1);
    }
}
