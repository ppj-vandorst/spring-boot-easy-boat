package com.novi.easyboat.controllers.dto;

import com.novi.easyboat.model.Booking;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class BookingInputDto {
    public Long boatId;
    public Long customerId;

    public LocalDateTime startTime;

    public LocalDateTime endTime;

    public Booking toBooking() {
        var booking = new Booking();
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        return booking;
    }
}
