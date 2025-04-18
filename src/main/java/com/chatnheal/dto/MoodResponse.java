// MoodResponse.java
package com.chatnheal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoodResponse {
    private String mood;
    private String note;
    private Date date;
}
