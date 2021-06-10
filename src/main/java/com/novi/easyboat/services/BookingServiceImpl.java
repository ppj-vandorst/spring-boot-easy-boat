package com.novi.easyboat.services;

import com.novi.easyboat.exceptions.BadRequestException;
import com.novi.easyboat.exceptions.NotFoundException;
import com.novi.easyboat.model.Booking;
import com.novi.easyboat.repositories.BoatRepository;
import com.novi.easyboat.repositories.BookingRepository;
import com.novi.easyboat.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private BoatRepository boatRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BoatRepository boatRepository, CustomerRepository customerRepository) {
        this.bookingRepository = bookingRepository;
        this.boatRepository = boatRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Booking> getBookingsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return bookingRepository.findByStartTimeBetween(start, end);
    }

    @Override
    public List<Booking> getBookingsForBoat(Long boatId) {
        var optionalBoat = boatRepository.findById(boatId);

        if (optionalBoat.isPresent()) {
            var boat = optionalBoat.get();
            return bookingRepository.findByBoat(boat);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public List<Booking> getBookingsForCustomer(Long customerId) {
        var optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            var customer = optionalCustomer.get();
            return bookingRepository.findByCustomer(customer);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public Booking saveBooking(Booking booking, Long boatId, Long customerId) {
        var optionalCustomer = customerRepository.findById(customerId);
        var optionalBoat = boatRepository.findById(boatId);

        if (optionalCustomer.isPresent() && optionalBoat.isPresent()) {
            var customer = optionalCustomer.get();
            var boat = optionalBoat.get();

            var overlappingStartBookings = bookingRepository.findByStartTimeBetweenAndBoat(booking.getStartTime(), booking.getEndTime(), boat);
            var overlappingEndBookings = bookingRepository.findByEndTimeBetweenAndBoat(booking.getStartTime(), booking.getEndTime(), boat);
            if (overlappingStartBookings.size() > 0 || overlappingEndBookings.size() > 0) {
                throw new BadRequestException();
            }

            booking.setCustomer(customer);
            booking.setBoat(boat);
            return bookingRepository.save(booking);
        } else {
            throw new NotFoundException();
        }
    }
}
