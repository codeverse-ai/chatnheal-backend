package com.chatnheal.controller;

import com.chatnheal.dto.JournalRequest;
import com.chatnheal.dto.JournalResponse;
import com.chatnheal.service.JournalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;


    @Operation(summary = "Write Entry in Journal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful wrote entry in Journal"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @PostMapping("/write")
    public ResponseEntity<JournalResponse> writeEntry(@RequestBody JournalRequest request,
                                                      HttpServletRequest http) {
        String userId = (String) http.getAttribute("uid");
        return ResponseEntity.ok(journalService.save(userId, request));
    }


    @Operation(summary = "Get All Entries from journal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Got all entries from journal"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @GetMapping("/all")
    public ResponseEntity<List<JournalResponse>> getAll( HttpServletRequest http) {
        String userId = (String) http.getAttribute("uid");
        return ResponseEntity.ok(journalService.getAll(userId));
    }
}
