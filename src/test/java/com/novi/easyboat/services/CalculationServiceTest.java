package com.novi.easyboat.services;

import com.novi.easyboat.exceptions.InvalidBookingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculationServiceTest {
    private CalculationService calculationService;

    @BeforeEach
    public void beforeAll() {
        calculationService = new CalculationServiceImpl();
    }

    // CalculateDiscount

    @Test
    void CalculateDiscountWhenIPutInNoDiscountCode0IsReturned() {
        // test implementation
    }

    @Test
    void CalculateDiscountWhenIPutInEZBOAT2021_100IsReturned() {
        // test implementation
    }

    @Test
    void CalculateDiscountWhenIPutInEZ2021_20PercentOfChargeIsReturned() {
        // test implementation
    }

    @Test
    void CalculateDiscountWhenIPutInAnInvalidDiscountCodeAnExceptionIsThrown() {
        // test implementation
    }

    // CalculateCharge
    @Test
    void CalculateChargeWhenIPutInAValidStartAndEndTimeACorrectChargeIsReturned() {
        // test implementation
    }

    @Test
    void CalculateChargeWhenIPutInAStartAndEndTimeWithDuration0AnExceptionIsThrown() {
        // test implementation
    }

    @Test
    void CalculateChargeWhenIPutInAStartAndEndTimeWithADurationOver24HoursAnExceptionIsThrown() {
        // test implementation
    }

}
