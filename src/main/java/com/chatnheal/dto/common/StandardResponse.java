package com.chatnheal.dto.common;

public class StandardResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public StandardResponse() {}

    public StandardResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> StandardResponse<T> success(T data, String message) {
        return new StandardResponse<>(true, message, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
