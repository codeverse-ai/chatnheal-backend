package com.chatnheal.controller;

import com.chatnheal.dto.BookingRequest;
import com.chatnheal.dto.BookingResponse;
import com.chatnheal.entity.CoachBooking;
import com.chatnheal.entity.CoachProfile;
import com.chatnheal.service.CoachService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;


    @Operation(summary = "Get List of coaches")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful GOT List of Coaches"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @GetMapping("/list")
    public ResponseEntity<List<CoachProfile>> listCoaches() {
        return ResponseEntity.ok(coachService.listCoaches());
    }


    @Operation(summary = "Book coaches")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Booked Coaches"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @PostMapping("/book")
    public ResponseEntity<BookingResponse> bookCoach(@RequestBody BookingRequest request,
                                                     @RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(coachService.bookCoach(userId, request));
    }


    @Operation(summary = "Show all my bookings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Got All my bookings"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @GetMapping("/my-bookings")
    public ResponseEntity<List<CoachBooking>> myBookings(@RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(coachService.getBookings(userId));
    }
}

