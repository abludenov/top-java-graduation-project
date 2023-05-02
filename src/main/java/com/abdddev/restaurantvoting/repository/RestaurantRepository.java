package com.abdddev.restaurantvoting.repository;

import com.abdddev.restaurantvoting.model.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface RestaurantRepository extends BaseRepository<Restaurant> {

    @Query("SELECT r FROM Restaurant r JOIN r.dishes  d WHERE d.date  = :date ORDER BY r.id ASC")
    List<Restaurant> getRestaurantsOnDate(LocalDate date);
}
