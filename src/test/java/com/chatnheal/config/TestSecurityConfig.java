package com.chatnheal.config;

import jakarta.servlet.Filter;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class TestSecurityConfig {
    @Bean
    public Filter firebaseAuthFilter() {
        return mock(Filter.class);
    }
}
