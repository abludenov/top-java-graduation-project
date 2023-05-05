package com.abdddev.restaurantvoting.web.vote;

import com.abdddev.restaurantvoting.model.Vote;
import com.abdddev.restaurantvoting.web.MatcherFactory;

import java.time.LocalDate;

import static com.abdddev.restaurantvoting.web.restaurant.RestaurantTestData.RESTAURANT1_ID;
import static com.abdddev.restaurantvoting.web.user.UserTestData.USER_ID;

public class VoteTestData {
    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER = MatcherFactory.usingEqualsComparator(Vote.class);

    public static final int VOTE_ID = 1;
    public static final Vote VOTE_1 = new Vote(VOTE_ID, LocalDate.now(), RESTAURANT1_ID, USER_ID);
    public static final Vote VOTE_2 = new Vote(VOTE_ID + 1, LocalDate.now(), RESTAURANT1_ID + 1, USER_ID + 1);
    public static final Vote VOTE_3 = new Vote(VOTE_ID + 2, LocalDate.now(), RESTAURANT1_ID, USER_ID + 3);

    public static Vote getUpdated() {
        return new Vote(VOTE_ID, LocalDate.now(), RESTAURANT1_ID + 1, USER_ID);
    }
}
