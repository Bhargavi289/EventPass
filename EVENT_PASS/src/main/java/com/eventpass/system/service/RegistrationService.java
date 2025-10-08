package com.eventpass.system.service;

import com.eventpass.system.model.Registration;
import com.eventpass.system.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration registerForEvent(Long userId, Long eventId) {
        Registration registration = new Registration(
                userId,
                eventId,
                "Paid",
                "PASS-" + UUID.randomUUID().toString().substring(0, 8)
        );
        return registrationRepository.save(registration);
    }

    public List<Registration> getUserRegistrations(Long userId) {
        return registrationRepository.findByUserId(userId);
    }
}
