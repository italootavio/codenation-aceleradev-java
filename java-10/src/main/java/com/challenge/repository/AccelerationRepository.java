package com.challenge.repository;

import com.challenge.entity.Acceleration;
import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    @Query("select c.id.acceleration from Candidate c where c.id.company.id = :companyId")
    List<Acceleration> findByCompanyId(Long companyId);
}
