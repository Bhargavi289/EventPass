package com.eventpass.system.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "VerificationLogs")
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    @ManyToOne
    @JoinColumn(name = "pass_id")
    private Pass pass;

    @ManyToOne
    @JoinColumn(name = "verified_by")
    private User verifiedBy; // admin or volunteer

    private Timestamp verificationTime;

    @Enumerated(EnumType.STRING)
    private Result verificationResult;

    private String remarks;

    public enum Result {
        VALID, INVALID, EXPIRED
    }

    // Constructors
    public VerificationLog() {}

    public VerificationLog(Pass pass, User verifiedBy, Result verificationResult, String remarks) {
        this.pass = pass;
        this.verifiedBy = verifiedBy;
        this.verificationResult = verificationResult;
        this.remarks = remarks;
        this.verificationTime = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }

    public User getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(User verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public Timestamp getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Timestamp verificationTime) {
        this.verificationTime = verificationTime;
    }

    public Result getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(Result verificationResult) {
        this.verificationResult = verificationResult;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
