package com.chatnheal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "mood_entries")
public class MoodEntry {
    @Id
    private String id;

    private String userId;
    private String mood; // HAPPY, SAD, STRESSED, OKAY, etc.
    private String note;
    private Date date;
}
