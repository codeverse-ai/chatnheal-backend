package com.chatnheal.service;

import com.chatnheal.dto.MoodRequest;
import com.chatnheal.dto.MoodResponse;
import com.chatnheal.repository.MoodEntryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MoodServiceTest {

    @InjectMocks
    private MoodService moodService;
    @Mock
    private MoodEntryRepository moodRepo;

    @Test
    void shouldSaveMoodAndReturnResponse() {
        Mockito.when(moodRepo.findByUserIdAndDateBetween(any(), any(), any())).thenReturn(Optional.empty());

        MoodRequest req = new MoodRequest();
        req.setMood("Happy");
        req.setNote("Feeling good");

        MoodResponse res = moodService.saveMood("user001", req);

        assertEquals("Happy", res.getMood());
        assertEquals("Feeling good", res.getNote());
    }
}
