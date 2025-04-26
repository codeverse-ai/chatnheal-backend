package com.chatnheal.service;

import com.chatnheal.dto.JournalRequest;
import com.chatnheal.dto.JournalResponse;
import com.chatnheal.entity.JournalEntry;
import com.chatnheal.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JournalService {

    @Autowired
    private JournalEntryRepository journalRepo;

    public JournalResponse save(String userId, JournalRequest request) {
        JournalEntry entry = new JournalEntry();
        entry.setUserId(userId);
        entry.setEntry(request.getEntry());
        entry.setDate(new Date());

        journalRepo.save(entry);

        JournalResponse response = new JournalResponse();
        response.setEntry(entry.getEntry());
        response.setDate(entry.getDate());

        return response;
    }

    public List<JournalResponse> getAll(String userId) {
        List<JournalEntry> entries = journalRepo.findByUserIdOrderByDateDesc(userId);
        List<JournalResponse> result = new ArrayList<>();
        for (JournalEntry e : entries) {
            JournalResponse r = new JournalResponse();
            r.setEntry(e.getEntry());
            r.setDate(e.getDate());
            result.add(r);
        }
        return result;
    }
}
