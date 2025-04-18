package com.chatnheal.repository;

import com.chatnheal.entity.CoachBooking;
import com.chatnheal.entity.CoachProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CoachProfileRepository extends MongoRepository<CoachProfile, String> {}

