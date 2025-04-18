package com.chatnheal.controller;

import com.chatnheal.dto.AstroRequest;
import com.chatnheal.dto.AstroResponse;
import com.chatnheal.service.AstroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/astro")
public class AstroController {

    @Autowired
    private AstroService astroService;

    @PostMapping("/profile")
    public ResponseEntity<AstroResponse> getAstroProfile(@RequestBody AstroRequest request,
                                                         @RequestHeader("X-User-Id") String userId) {
        AstroResponse profile = astroService.generateProfile(userId, request.getDateOfBirth());
        return ResponseEntity.ok(profile);
    }
}

