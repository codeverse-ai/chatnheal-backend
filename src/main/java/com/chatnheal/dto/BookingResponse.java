package com.chatnheal.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private String coachName;
    private Date time;
    private String status;
    private String notes;
}