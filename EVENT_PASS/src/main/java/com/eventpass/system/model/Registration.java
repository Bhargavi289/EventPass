package com.eventpass.system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long eventId;
    private String paymentStatus;
    private String passId;

    public Registration() {}

    public Registration(Long userId, Long eventId, String paymentStatus, String passId) {
        this.userId = userId;
        this.eventId = eventId;
        this.paymentStatus = paymentStatus;
        this.passId = passId;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public String getPassId() { return passId; }
    public void setPassId(String passId) { this.passId = passId; }
}
