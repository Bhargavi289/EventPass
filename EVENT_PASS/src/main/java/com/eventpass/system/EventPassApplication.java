package com.eventpass.system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eventpass.system.model.Pass;
import com.eventpass.system.model.Registration;
import com.eventpass.system.model.VerificationLog;
import com.eventpass.system.repository.PassRepository;
import com.eventpass.system.repository.VerificationLogRepository;

@SpringBootApplication
public class EventPassApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventPassApplication.class, args);
    }

    }
