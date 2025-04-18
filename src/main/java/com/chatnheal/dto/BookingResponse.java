package com.chatnheal.dto;


import lombok.Data;

import java.util.Date;

@Data
public class BookingResponse {
    private String coachName;
    private Date time;
    private String status;
    private String notes;
}