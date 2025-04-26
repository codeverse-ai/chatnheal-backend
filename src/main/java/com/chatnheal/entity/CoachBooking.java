package com.chatnheal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "coach_bookings")
public class CoachBooking {
    @Id
    private String id;
    private String userId;
    private String coachId;
    private Date bookingTime;
    private String status; // REQUESTED, CONFIRMED, COMPLETED
    private String notes;
}
