package com.eventpass.system.service;

import com.eventpass.system.model.VerificationLog;
import com.eventpass.system.repository.VerificationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationLogService {

    @Autowired
    private VerificationLogRepository logRepository;

    public VerificationLog createLog(VerificationLog log) {
        return logRepository.save(log);
    }

    public List<VerificationLog> getAllLogs() {
        return logRepository.findAll();
    }

    public void deleteLog(Integer logId) {
        logRepository.deleteById(logId);
    }
}
