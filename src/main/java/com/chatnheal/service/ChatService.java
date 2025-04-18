package com.chatnheal.service;

import com.chatnheal.dto.ChatRequest;
import com.chatnheal.dto.ChatResponse;
import com.chatnheal.entity.ChatMessage;
import com.chatnheal.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChatService {

    @Autowired
    private com.chatnheal.service.GptService gptService;

    @Autowired
    private ChatMessageRepository chatRepo;

    public ChatResponse processMessage(String userId, ChatRequest request) {
        String systemPrompt = "You are a wise and caring grandmother who listens deeply and replies warmly.";

        String gptReply = gptService.getReply(systemPrompt, request.getUserMessage());

        ChatMessage chat = new ChatMessage();
        chat.setUserId(userId);
        chat.setCompanionId(request.getCompanionId());
        chat.setUserMessage(request.getUserMessage());
        chat.setGptReply(gptReply);
        chat.setTimestamp(new Date());

        chatRepo.save(chat);

        return new ChatResponse(gptReply, "Wise Dadi");
    }
}
