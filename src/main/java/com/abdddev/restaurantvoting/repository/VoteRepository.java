package com.abdddev.restaurantvoting.repository;

import com.abdddev.restaurantvoting.model.Vote;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
public interface VoteRepository extends BaseRepository<Vote> {
    Optional<Vote> getVoteByIdAndUserId(int id, int userId);
    List<Vote> findAllByDate(LocalDate date);
}
