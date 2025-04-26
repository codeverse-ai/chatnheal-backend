package com.chatnheal.controller;

import com.chatnheal.dto.AstroRequest;
import com.chatnheal.dto.AstroResponse;
import com.chatnheal.service.AstroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/astro")
public class AstroController {

    @Autowired
    private AstroService astroService;


    @Operation(summary = "Get Astro profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful GPT Astro profile"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @PostMapping("/profile")
    public ResponseEntity<AstroResponse> getAstroProfile(@RequestBody AstroRequest request,
                                                         HttpServletRequest http) {
        String userId = (String) http.getAttribute("uid");
        AstroResponse profile = astroService.generateProfile(userId, request.getDateOfBirth());
        return ResponseEntity.ok(profile);
    }
}

