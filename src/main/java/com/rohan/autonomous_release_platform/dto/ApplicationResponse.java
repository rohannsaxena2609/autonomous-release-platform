package com.rohan.autonomous_release_platform.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApplicationResponse {

    private Long id;

    private String name;

    private String version;

    private String owner;

    private String repositoryUrl;

    private String status;

    private LocalDateTime createdAt;
}