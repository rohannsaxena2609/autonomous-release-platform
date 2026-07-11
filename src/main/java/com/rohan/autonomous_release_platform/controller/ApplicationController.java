package com.rohan.autonomous_release_platform.controller;

import com.rohan.autonomous_release_platform.dto.ApiResponse;
import com.rohan.autonomous_release_platform.dto.ApplicationRequest;
import com.rohan.autonomous_release_platform.dto.ApplicationResponse;
import com.rohan.autonomous_release_platform.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@Tag(name = "Application API", description = "CRUD operations for Applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Operation(summary = "Get all applications")
    @GetMapping
    public ResponseEntity<List<ApplicationResponse>> getAllApplications() {

        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @Operation(summary = "Get application by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponse> getApplication(@PathVariable Long id) {

        return ResponseEntity.ok(applicationService.getApplication(id));
    }

    @Operation(summary = "Create a new application")
    @PostMapping
    public ResponseEntity<ApplicationResponse> createApplication(
            @Valid @RequestBody ApplicationRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(applicationService.createApplication(request));
    }

    @Operation(summary = "Update an existing application")
    @PutMapping("/{id}")
    public ResponseEntity<ApplicationResponse> updateApplication(
            @PathVariable Long id,
            @Valid @RequestBody ApplicationRequest request) {

        return ResponseEntity.ok(
                applicationService.updateApplication(id, request));
    }

    @Operation(summary = "Delete an application")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteApplication(@PathVariable Long id) {

        applicationService.deleteApplication(id);

        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("Application deleted successfully.")
                .build();

        return ResponseEntity.ok(response);
    }
}