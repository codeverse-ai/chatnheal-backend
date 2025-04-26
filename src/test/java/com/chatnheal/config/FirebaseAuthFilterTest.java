package com.chatnheal.config;

import com.google.firebase.auth.FirebaseAuth;
import jakarta.servlet.FilterChain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class FirebaseAuthFilterTest {

    @InjectMocks
    private FirebaseAuthFilter filter;
    @Mock
    private FirebaseAuth firebaseAuth;

    @Test
    void shouldRejectIfTokenMissing() throws Exception {
        MockHttpServletRequest req = new MockHttpServletRequest();
        MockHttpServletResponse res = new MockHttpServletResponse();

        FilterChain chain = Mockito.mock(FilterChain.class);

        filter.doFilter(req, res, chain);

        assertEquals(401, res.getStatus());
        assertTrue(res.getContentAsString().contains("Missing or invalid"));
    }
}
