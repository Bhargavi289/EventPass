package com.eventpass.system.repository;

import com.eventpass.system.model.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassRepository extends JpaRepository<Pass, Integer> {
    Pass findByRegistration_Id(Long registrationId);

}
