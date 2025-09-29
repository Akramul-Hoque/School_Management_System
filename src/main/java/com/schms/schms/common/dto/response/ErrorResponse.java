package com.schms.schms.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String error;       // short error code (e.g., NOT_FOUND, ERROR)
    private String message;     // detailed message
    private int status;         // HTTP status code
    private LocalDateTime timestamp;  // when the error occurred
}