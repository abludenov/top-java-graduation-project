package com.abdddev.restaurantvoting.to;

import com.abdddev.restaurantvoting.model.Restaurant;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class RestaurantTo extends NamedTo {

    public RestaurantTo(Integer id, String name) {
        super(id, name);
    }

    public RestaurantTo(Restaurant r) {
        this(r.getId(), r.getName());
    }

}