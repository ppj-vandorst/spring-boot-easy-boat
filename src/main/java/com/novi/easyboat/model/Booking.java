package com.novi.easyboat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Boat boat;

    @ManyToOne
    Customer customer;

    LocalDateTime startTime;

    LocalDateTime endTime;

    // Getters
    public Long getId() {
        return id;
    }

    public Boat getBoat() {
        return boat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
