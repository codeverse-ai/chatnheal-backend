package com.chatnheal.service;

import com.chatnheal.dto.ChatRequest;
import com.chatnheal.dto.ChatResponse;
import com.chatnheal.entity.ChatMessage;
import com.chatnheal.repository.ChatMessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import  com.chatnheal.service.GptService;

class ChatServiceTest {

    @InjectMocks
    private ChatService chatService;

    @Mock
    private GptService gptService;

    @Mock
    private ChatMessageRepository chatRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnGptReplyAndSaveMessage() {
        String userId = "user123";
        ChatRequest request = new ChatRequest();
        request.setUserMessage("Hi");
        request.setCompanionId("dadi001");

        Mockito.when(gptService.getReply(any(), eq("Hi")))
                .thenReturn("Hello beta, how can I help?");

        ChatResponse response = chatService.processMessage(userId, request);

        assertNotNull(response);
        assertEquals("Wise Dadi", response.getPersonaName());
        assertEquals("Hello beta, how can I help?", response.getReply());

        Mockito.verify(chatRepo, Mockito.times(1)).save(any(ChatMessage.class));
    }

        @Test
        void shouldGenerateReplyAndSave() {
            ChatRequest req = new ChatRequest();
            req.setUserMessage("Hello");
            req.setCompanionId("dadi");

            Mockito.when(gptService.getReply(any(), eq("Hello"))).thenReturn("Hello child");

            ChatResponse res = chatService.processMessage("user123", req);

            assertEquals("Hello child", res.getReply());
            Mockito.verify(chatRepo).save(any());
        }


}
