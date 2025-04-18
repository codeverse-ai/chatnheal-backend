package com.chatnheal.controller;

import com.chatnheal.dto.ChatRequest;
import com.chatnheal.dto.ChatResponse;
import com.chatnheal.service.ChatService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.hamcrest.Matchers.containsString;

@WebMvcTest(ChatController.class)
class ChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChatService chatService;

    @Test
    void shouldReturnGptReplyJson() throws Exception {
        ChatResponse mockResponse = new ChatResponse("Hello child!", "Wise Dadi");

        Mockito.when(chatService.processMessage(Mockito.anyString(), Mockito.any()))
                .thenReturn(mockResponse);

        mockMvc.perform(post("/chat/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-User-Id", "testUser")
                        .content("{\"userMessage\": \"Hi\", \"companionId\": \"dadi001\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Wise Dadi")))
                .andExpect(jsonPath("$.reply").value("Hello child!"));
    }
}
