package com.rohan.autonomous_release_platform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Application name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Version is required")
    @Column(nullable = false)
    private String version;

    @NotBlank(message = "Owner is required")
    @Column(nullable = false)
    private String owner;

    @NotBlank(message = "Repository URL is required")
    @Column(nullable = false)
    private String repositoryUrl;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();

        if (status == null || status.isBlank()) {
            status = "CREATED";
        }
    }
}