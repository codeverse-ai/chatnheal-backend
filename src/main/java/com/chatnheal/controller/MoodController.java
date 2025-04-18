package com.chatnheal.controller;

import com.chatnheal.dto.MoodRequest;
import com.chatnheal.dto.MoodResponse;
import com.chatnheal.service.MoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;


    @Operation(summary = "Track Mood Today")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful GOT Mood Track today"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @PostMapping("/today")
    public ResponseEntity<MoodResponse> trackToday(@RequestBody MoodRequest request,
                                                   @RequestHeader("X-User-Id") String userId) {
        MoodResponse response = moodService.saveMood(userId, request);
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Get History of Mood track")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Got History of Mood Tracked"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @GetMapping("/history")
    public ResponseEntity<List<MoodResponse>> getHistory(@RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(moodService.getHistory(userId));
    }
}
