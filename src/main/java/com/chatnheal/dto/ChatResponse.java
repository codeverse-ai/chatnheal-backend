package com.chatnheal.dto;

public class ChatResponse {
    private String reply;
    private String personaName;

    public ChatResponse() {}

    public ChatResponse(String reply, String personaName) {
        this.reply = reply;
        this.personaName = personaName;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;
    }
}
