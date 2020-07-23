package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    @Query("select MAX(s.score) from Submission s where s.id.challenge.id = :challengeId")
    Optional<BigDecimal> findHigherScoreByChallengeId(Long challengeId);
    //findHigherScoreByChallengeId: Buscar o maior score de um determinado desafio

    @Query("from Submission s join s.id.challenge.accelerations a" +
            " where s.id.challenge.id = :challengeId and a.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
    //findByChallegeIdAndAccelerationId: buscar submissões de um determinado desafio de uma determinada aceleração
}
