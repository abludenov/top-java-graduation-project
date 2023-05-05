package com.abdddev.restaurantvoting.to;

import com.abdddev.restaurantvoting.model.Restaurant;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class RestaurantTo extends NamedTo {
    String description;

    public RestaurantTo(Integer id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public RestaurantTo(Restaurant r) {
        this(r.getId(), r.getName(), r.getDescription());
    }

}