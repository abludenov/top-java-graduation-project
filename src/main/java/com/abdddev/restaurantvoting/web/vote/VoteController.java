package com.abdddev.restaurantvoting.web.vote;

import com.abdddev.restaurantvoting.repository.RestaurantRepository;
import com.abdddev.restaurantvoting.repository.VoteRepository;
import com.abdddev.restaurantvoting.service.VoteService;
import com.abdddev.restaurantvoting.to.RestaurantTo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.abdddev.restaurantvoting.web.vote.VoteController.REST_URL;
import static com.abdddev.restaurantvoting.util.RestaurantUtil.convertToTo;

@Tag(
        name = "Vote Controller",
        description = "Allows authenticated users to view restaurants with menus and vote counts, and cast votes")
@Slf4j
@RestController
@RequestMapping(value = REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class VoteController {
    static final String REST_URL = "/api/voting";
    private final VoteRepository voteRepository;
    private final VoteService voteService;
    private final RestaurantRepository restaurantRepository;

    @Operation(
            summary = "Get all Restaurants with today's menu",
            description = "Returns all Restaurants with today's menu")
    @GetMapping
    public List<RestaurantTo> getRestaurants() {
        log.info("Get restaurants for voting");
        return convertToTo(restaurantRepository.getRestaurantsOnDate(LocalDate.now()));
    }
}
