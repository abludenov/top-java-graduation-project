package com.abdddev.restaurantvoting.service;

import com.abdddev.restaurantvoting.exception.DataIncorrectException;
import com.abdddev.restaurantvoting.model.Vote;
import com.abdddev.restaurantvoting.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class VoteService {
    public static LocalTime votingStopTime = LocalTime.of(11, 0);
    private final VoteRepository voteRepository;

    public void update(Vote vote) {
        if(LocalTime.now().isAfter(votingStopTime))
            throw new DataIncorrectException("You can't update your vote after 11:00");
    }
}
