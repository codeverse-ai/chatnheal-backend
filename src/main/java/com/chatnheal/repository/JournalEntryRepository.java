package com.chatnheal.repository;

import com.chatnheal.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {
    List<JournalEntry> findByUserIdOrderByDateDesc(String userId);
}