package com.chatnheal.service;

import com.chatnheal.dto.AstroResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AstroServiceTest {

    private final AstroService astroService = new AstroService();

    @Test
    void shouldReturnCorrectZodiacMatch() {
        AstroResponse response = astroService.generateProfile("userX", "1995-08-15");

        assertEquals("Leo", response.getZodiacSign());
        assertFalse(response.getCompanions().isEmpty());
    }

}
