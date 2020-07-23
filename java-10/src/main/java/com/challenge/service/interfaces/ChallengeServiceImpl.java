package com.challenge.service.interfaces;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChallengeServiceImpl implements ChallengeServiceInterface{

    private ChallengeRepository challengeRepository;

    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return this.challengeRepository.findByAccelerationIdAndUserId(accelerationId,userId);
    }

    @Override
    public Challenge save(Challenge object) {
        return this.challengeRepository.save(object);
    }
}
