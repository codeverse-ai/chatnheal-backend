package com.chatnheal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "coach_profiles")
public class CoachProfile {
    @Id
    private String id;
    private String name;
    private String bio;
    private String languages;
    private String profilePicUrl;
    private boolean available;
    private double sessionFee;
}
