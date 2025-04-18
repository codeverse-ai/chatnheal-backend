package com.chatnheal.service;

import com.chatnheal.dto.MoodRequest;
import com.chatnheal.dto.MoodResponse;
import com.chatnheal.entity.MoodEntry;
import com.chatnheal.repository.MoodEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MoodService {

    @Autowired
    private MoodEntryRepository moodRepo;

    public MoodResponse saveMood(String userId, MoodRequest request) {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date start = cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date end = cal.getTime();

        MoodEntry entry = moodRepo.findByUserIdAndDateBetween(userId, start, end)
                .orElse(new MoodEntry());

        entry.setUserId(userId);
        entry.setMood(request.getMood());
        entry.setNote(request.getNote());
        entry.setDate(now);

        moodRepo.save(entry);

        MoodResponse response = new MoodResponse();
        response.setMood(entry.getMood());
        response.setNote(entry.getNote());
        response.setDate(entry.getDate());

        return response;
    }

    public List<MoodResponse> getHistory(String userId) {
        List<MoodEntry> entries = moodRepo.findByUserIdOrderByDateDesc(userId);
        List<MoodResponse> result = new ArrayList<>();

        for (MoodEntry e : entries) {
            MoodResponse r = new MoodResponse();
            r.setMood(e.getMood());
            r.setNote(e.getNote());
            r.setDate(e.getDate());
            result.add(r);
        }

        return result;
    }
}
