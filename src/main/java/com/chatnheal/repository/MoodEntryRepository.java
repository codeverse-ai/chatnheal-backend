package com.chatnheal.repository;

import com.chatnheal.entity.MoodEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.Optional;
import java.util.List;

public interface MoodEntryRepository extends MongoRepository<MoodEntry, String> {
    Optional<MoodEntry> findByUserIdAndDateBetween(String userId, Date startOfDay, Date endOfDay);
    List<MoodEntry> findByUserIdOrderByDateDesc(String userId);
}
