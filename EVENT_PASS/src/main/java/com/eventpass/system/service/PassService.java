package com.eventpass.system.service;

import com.eventpass.system.model.Pass;
import com.eventpass.system.repository.PassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassService {

    @Autowired
    private PassRepository passRepository;

    public Pass createPass(Pass pass) {
        return passRepository.save(pass);
    }

    public List<Pass> getAllPasses() {
        return passRepository.findAll();
    }

   public Pass getPassByRegistrationId(Long registrationId) {
    return passRepository.findByRegistration_Id(registrationId);
}


    public Pass updatePass(Pass pass) {
        return passRepository.save(pass);
    }

    public void deletePass(Integer passId) {
        passRepository.deleteById(passId);
    }
}
