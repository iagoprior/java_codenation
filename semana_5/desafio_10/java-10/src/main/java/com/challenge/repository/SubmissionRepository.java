package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query(value = "select nvl2(max(s.score), max(s.score), 0) from submission s where s.challenge_id = ?1",nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(Long challengeId);

    @Query(value = "select * from submission INNER JOIN challenge ON submission.challenge_id = challenge.id INNER JOIN acceleration ON challenge.id = acceleration.challenge_id WHERE challenge.id = ?1 AND acceleration.id = ?2",nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
}
