package com.novi.easyboat.services;

import com.novi.easyboat.model.Boat;
import com.novi.easyboat.model.Booking;
import com.novi.easyboat.model.BookingStatus;
import com.novi.easyboat.model.Customer;
import com.novi.easyboat.repositories.BoatRepository;
import com.novi.easyboat.repositories.BookingRepository;
import com.novi.easyboat.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    BoatRepository boatRepository;

    @Mock
    BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Captor
    ArgumentCaptor<Booking> bookingCaptor;

    @Test
    public void planBookingShouldCorrectlyPlanAValidBooking() {
        // Test implementation
    }
}
