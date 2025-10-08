package com.eventpass.system.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Passes")
public class Pass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passId;

    @OneToOne
    @JoinColumn(name = "registration_id", unique = true)
    private Registration registration;

    private String qrCode;

    private Timestamp issueDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    public enum Status {
        ACTIVE, USED, EXPIRED
    }

    // Constructors
    public Pass() {}

    public Pass(Registration registration, String qrCode, Status status) {
        this.registration = registration;
        this.qrCode = qrCode;
        this.status = status;
        this.issueDate = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public Integer getPassId() {
        return passId;
    }

    public void setPassId(Integer passId) {
        this.passId = passId;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
