package com.chatnheal.dto;

import lombok.Data;

@Data
public class ChatRequest {
    private String userMessage;
    private String companionId;
}
