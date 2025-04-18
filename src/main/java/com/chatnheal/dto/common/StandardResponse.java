package com.chatnheal.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> StandardResponse<T> success(T data, String message) {
        return new StandardResponse<>(true, message, data);
    }

    public static <T> StandardResponse<T> failure(String message) {
        return new StandardResponse<>(false, message, null);
    }
}

