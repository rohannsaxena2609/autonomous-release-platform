package com.rohan.autonomous_release_platform.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ApplicationRequest {

    @NotBlank(message = "Application name is required")
    private String name;

    @NotBlank(message = "Version is required")
    private String version;

    @NotBlank(message = "Owner is required")
    private String owner;

    @NotBlank(message = "Repository URL is required")
    private String repositoryUrl;

    private String status;
}