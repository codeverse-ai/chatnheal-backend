package com.chatnheal.service;

import com.chatnheal.dto.JournalRequest;
import com.chatnheal.dto.JournalResponse;
import com.chatnheal.repository.JournalEntryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class JournalServiceTest {

    @InjectMocks
    private JournalService journalService;
    @Mock
    private JournalEntryRepository journalRepo;

    @Test
    void shouldSaveAndReturnJournalResponse() {
        JournalRequest req = new JournalRequest();
        req.setEntry("Today was amazing");

        JournalResponse res = journalService.save("userABC", req);

        assertEquals("Today was amazing", res.getEntry());
        Mockito.verify(journalRepo).save(any());
    }
}
