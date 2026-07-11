package com.rohan.autonomous_release_platform.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse {

    private boolean success;

    private String message;

    private Object data;

    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}