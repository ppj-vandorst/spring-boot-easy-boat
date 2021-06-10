package com.novi.easyboat.services;

import com.novi.easyboat.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
    List<Booking> getBookingsBetweenDates(LocalDateTime start, LocalDateTime end);

    List<Booking> getBookingsForBoat(Long boatId);

    List<Booking> getBookingsForCustomer(Long customerId);

    Booking saveBooking(Booking booking, Long boatId, Long customerId);
}
