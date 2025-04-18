package com.chatnheal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "astro_profiles")
public class AstroProfile {
    @Id
    private String id;
    private String userId;
    private String dateOfBirth;
    private String zodiacSign;
    private String sunSign; // optional for expansion
}
