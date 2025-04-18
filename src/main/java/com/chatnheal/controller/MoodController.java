package com.chatnheal.controller;

import com.chatnheal.dto.MoodRequest;
import com.chatnheal.dto.MoodResponse;
import com.chatnheal.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @PostMapping("/today")
    public ResponseEntity<MoodResponse> trackToday(@RequestBody MoodRequest request,
                                                   @RequestHeader("X-User-Id") String userId) {
        MoodResponse response = moodService.saveMood(userId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<List<MoodResponse>> getHistory(@RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(moodService.getHistory(userId));
    }
}
