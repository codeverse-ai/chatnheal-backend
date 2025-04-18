package com.chatnheal.service;

import com.chatnheal.dto.BookingRequest;
import com.chatnheal.dto.BookingResponse;
import com.chatnheal.entity.CoachBooking;
import com.chatnheal.entity.CoachProfile;
import com.chatnheal.repository.CoachBookingRepository;
import com.chatnheal.repository.CoachProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoachService {

    @Autowired
    private CoachProfileRepository coachRepo;

    @Autowired
    private CoachBookingRepository bookingRepo;

    public List<CoachProfile> listCoaches() {
        return coachRepo.findAll();
    }

    public BookingResponse bookCoach(String userId, BookingRequest request) {
        CoachProfile coach = coachRepo.findById(request.getCoachId()).orElseThrow();

        CoachBooking booking = new CoachBooking();
        booking.setUserId(userId);
        booking.setCoachId(coach.getId());
        booking.setBookingTime(new Date());
        booking.setStatus("REQUESTED");
        booking.setNotes(request.getNotes());

        bookingRepo.save(booking);

        BookingResponse response = new BookingResponse();
        response.setCoachName(coach.getName());
        response.setTime(booking.getBookingTime());
        response.setStatus("REQUESTED");
        response.setNotes(booking.getNotes());

        return response;
    }

    public List<CoachBooking> getBookings(String userId) {
        return bookingRepo.findByUserIdOrderByBookingTimeDesc(userId);
    }
}
