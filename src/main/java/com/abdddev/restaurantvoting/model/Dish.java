package com.abdddev.restaurantvoting.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "dish")
@Getter
@Setter
@NoArgsConstructor
public class Dish extends NamedEntity {

    @Column(name = "dish_date", nullable = false)
    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public Dish(Integer id, String name, LocalDate date) {
        super(id, name);
        this.date = date;
    }

    public Dish(Integer id, String name, LocalDate date, Restaurant restaurant) {
        super(id, name);
        this.date = date;
        this.restaurant = restaurant;
    }
}
