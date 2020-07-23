package com.challenge.service.interfaces;
import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidadeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidadeServiceImpl implements CandidateServiceInterface{
    @Autowired
    private CandidadeRepository candidadeRepository;

    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return this.candidadeRepository.findById(id);
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {

        return this.candidadeRepository.findByUserIdAndCompanyIdAndAccelerationId(userId,companyId,accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return this.candidadeRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return this.candidadeRepository.findByAccelerationId(accelerationId);
    }

    @Override
    public Candidate save(Candidate object) {
        return this.candidadeRepository.save(object);
    }
}