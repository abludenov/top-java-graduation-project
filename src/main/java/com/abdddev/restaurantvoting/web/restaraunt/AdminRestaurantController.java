package com.abdddev.restaurantvoting.web.restaraunt;

import com.abdddev.restaurantvoting.model.Restaurant;
import com.abdddev.restaurantvoting.repository.RestaurantRepository;
import com.abdddev.restaurantvoting.to.RestaurantTo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.abdddev.restaurantvoting.util.RestaurantUtil.convertToTo;
import static com.abdddev.restaurantvoting.util.validation.ValidationUtil.assureIdConsistent;
import static com.abdddev.restaurantvoting.util.validation.ValidationUtil.checkNew;

@Tag(name = "Admin Restaurant", description = "The Restaurant API")
@RestController
@RequestMapping(value = AdminRestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AdminRestaurantController {
    public static final String REST_URL = "/admin/restaurants";
    private final RestaurantRepository restaurantRepository;

    @Operation(summary = "Get Restaurant by id")
    @GetMapping("/{id}")
    public RestaurantTo get(@PathVariable int id) {
        return convertToTo(restaurantRepository.getExisted(id));
    }

    @Operation(summary = "Get Restaurant by id with dishes")
    @GetMapping("/{id}/with-dishes")
    public Restaurant getWithDishes(@PathVariable int id) {
        return restaurantRepository.getExistedWithDishes(id);
    }

    @Operation(summary = "Delete restaurant by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        restaurantRepository.deleteExisted(id);
    }

    @Operation(summary = "Get all Restaurants")
    @GetMapping
    public List<RestaurantTo> getAll() {
        return convertToTo(restaurantRepository.getAll());
    }

    @Operation(summary = "Update Restaurant by id")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody Restaurant restaurant, @PathVariable int id) {
        assureIdConsistent(restaurant, id);
        restaurantRepository.save(restaurant);
    }

    @Operation(summary = "Create Restaurant")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@Valid @RequestBody Restaurant restaurant) {
        checkNew(restaurant);
        Restaurant created = restaurantRepository.save(restaurant);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}