package com.abdddev.restaurantvoting.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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

    @Column(name = "price", nullable = false)
    @NotNull
    @Min(value = 1)
    private double price;

    public Dish(Integer id, String name, LocalDate date, Double price) {
        super(id, name);
        this.date = date;
        this.price = price;
    }

    public Dish(Integer id, String name, LocalDate date, Restaurant restaurant, Double price) {
        super(id, name);
        this.date = date;
        this.restaurant = restaurant;
        this.price = price;
    }
}
