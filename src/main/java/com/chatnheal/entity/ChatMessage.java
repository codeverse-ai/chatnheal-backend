package com.chatnheal.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "chat_messages")
public class ChatMessage {
    @Id
    private String id;

    private String userId;
    private String companionId;
    private String userMessage;
    private String gptReply;
    private Date timestamp;
}
