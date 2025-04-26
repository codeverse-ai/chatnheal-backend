package com.chatnheal.service;

import com.chatnheal.dto.BookingRequest;
import com.chatnheal.dto.BookingResponse;
import com.chatnheal.entity.CoachProfile;
import com.chatnheal.repository.CoachBookingRepository;
import com.chatnheal.repository.CoachProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CoachServiceTest {

    @InjectMocks
    private CoachService coachService;
    @Mock
    private CoachProfileRepository coachRepo;
    @Mock private CoachBookingRepository bookingRepo;

    @Test
    void shouldReturnListOfCoaches() {
        List<CoachProfile> list = List.of(new CoachProfile());
        Mockito.when(coachRepo.findAll()).thenReturn(list);

        assertEquals(1, coachService.listCoaches().size());
    }

    @Test
    void shouldBookCoachSuccessfully() {
        CoachProfile coach = new CoachProfile();
        coach.setId("coach123");
        coach.setName("Empath Listener");

        Mockito.when(coachRepo.findById("coach123")).thenReturn(Optional.of(coach));

        BookingRequest req = new BookingRequest();
        req.setCoachId("coach123");
        req.setNotes("Need help");

        BookingResponse res = coachService.bookCoach("userX", req);

        assertEquals("Empath Listener", res.getCoachName());
        assertEquals("REQUESTED", res.getStatus());
    }
}
