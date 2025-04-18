package com.chatnheal.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JournalResponse {
    private String entry;
    private Date date;
}
