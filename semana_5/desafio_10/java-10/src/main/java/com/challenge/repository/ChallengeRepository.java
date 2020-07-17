package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query(value = "SELECT * FROM challenge " +
            "INNER JOIN acceleration " +
            "ON challenge.id = acceleration.challenge_id " +
            "INNER JOIN submission " +
            "ON challenge.id = submission.challenge_id " +
            "WHERE acceleration.id = ?1 " +
            "AND submission.user_id = ?2",nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);
}
