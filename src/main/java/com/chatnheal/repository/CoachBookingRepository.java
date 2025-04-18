package com.chatnheal.repository;


import com.chatnheal.entity.CoachBooking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CoachBookingRepository extends MongoRepository<CoachBooking, String> {
    List<CoachBooking> findByUserIdOrderByBookingTimeDesc(String userId);
}