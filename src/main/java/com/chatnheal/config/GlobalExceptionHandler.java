package com.chatnheal.config;

import com.chatnheal.dto.common.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

  /*  @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardResponse<Object>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(StandardResponse.failure(ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardResponse<Object>> handleRuntime(RuntimeException ex) {
        return ResponseEntity.internalServerError().body(StandardResponse.failure("Server error: " + ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardResponse<Object>> handleGeneral(Exception ex) {
        return ResponseEntity.internalServerError().body(StandardResponse.failure("Unexpected error occurred."));
    }*/
}

