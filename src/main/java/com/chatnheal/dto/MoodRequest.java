// MoodRequest.java
package com.chatnheal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoodRequest {
    private String mood;
    private String note;
}

