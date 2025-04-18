// MoodResponse.java
package com.chatnheal.dto;

import lombok.Data;
import java.util.Date;

@Data
public class MoodResponse {
    private String mood;
    private String note;
    private Date date;
}
