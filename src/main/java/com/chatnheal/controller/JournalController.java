package com.chatnheal.controller;

import com.chatnheal.dto.JournalRequest;
import com.chatnheal.dto.JournalResponse;
import com.chatnheal.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping("/write")
    public ResponseEntity<JournalResponse> writeEntry(@RequestBody JournalRequest request,
                                                      @RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(journalService.save(userId, request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<JournalResponse>> getAll(@RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(journalService.getAll(userId));
    }
}
