package com.chatnheal.controller;

import com.chatnheal.dto.ChatRequest;
import com.chatnheal.dto.ChatResponse;
import com.chatnheal.dto.common.StandardResponse;
import com.chatnheal.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Operation(summary = "Send a message to the AI companion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful GPT reply"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @PostMapping("/send")
    public ResponseEntity<StandardResponse<ChatResponse>> sendMessage(@RequestBody ChatRequest request,
                                                                      @RequestHeader("X-User-Id") String userId) {
        ChatResponse response = chatService.processMessage(userId, request);
        return ResponseEntity.ok(StandardResponse.success(response, "Message sent successfully"));
    }
}

