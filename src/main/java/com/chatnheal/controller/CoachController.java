package com.chatnheal.controller;

import com.chatnheal.dto.BookingRequest;
import com.chatnheal.dto.BookingResponse;
import com.chatnheal.entity.CoachBooking;
import com.chatnheal.entity.CoachProfile;
import com.chatnheal.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @GetMapping("/list")
    public ResponseEntity<List<CoachProfile>> listCoaches() {
        return ResponseEntity.ok(coachService.listCoaches());
    }

    @PostMapping("/book")
    public ResponseEntity<BookingResponse> bookCoach(@RequestBody BookingRequest request,
                                                     @RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(coachService.bookCoach(userId, request));
    }

    @GetMapping("/my-bookings")
    public ResponseEntity<List<CoachBooking>> myBookings(@RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(coachService.getBookings(userId));
    }
}

