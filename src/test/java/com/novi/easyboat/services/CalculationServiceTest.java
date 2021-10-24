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
    public void beforeEach() {
        calculationService = new CalculationServiceImpl();
    }

    // CalculateDiscount

    @Test
    void dummy() {
    }

}
