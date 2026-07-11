package com.rohan.autonomous_release_platform.service;

import com.rohan.autonomous_release_platform.dto.ApplicationRequest;
import com.rohan.autonomous_release_platform.dto.ApplicationResponse;
import com.rohan.autonomous_release_platform.exception.ResourceNotFoundException;
import com.rohan.autonomous_release_platform.model.Application;
import com.rohan.autonomous_release_platform.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository repository;

    public ApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    public List<ApplicationResponse> getAllApplications() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ApplicationResponse getApplication(Long id) {

        Application application = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Application with ID " + id + " not found"));

        return mapToResponse(application);
    }

    public ApplicationResponse createApplication(ApplicationRequest request) {

        Application application = Application.builder()
                .name(request.getName())
                .version(request.getVersion())
                .owner(request.getOwner())
                .repositoryUrl(request.getRepositoryUrl())
                .status(request.getStatus())
                .build();

        Application saved = repository.save(application);

        return mapToResponse(saved);
    }

    public ApplicationResponse updateApplication(Long id,
                                                 ApplicationRequest request) {

        Application application = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Application with ID " + id + " not found"));

        application.setName(request.getName());
        application.setVersion(request.getVersion());
        application.setOwner(request.getOwner());
        application.setRepositoryUrl(request.getRepositoryUrl());
        application.setStatus(request.getStatus());

        return mapToResponse(repository.save(application));
    }

    public void deleteApplication(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Application with ID " + id + " not found");
        }

        repository.deleteById(id);
    }

    private ApplicationResponse mapToResponse(Application application) {

        return ApplicationResponse.builder()
                .id(application.getId())
                .name(application.getName())
                .version(application.getVersion())
                .owner(application.getOwner())
                .repositoryUrl(application.getRepositoryUrl())
                .status(application.getStatus())
                .createdAt(application.getCreatedAt())
                .build();
    }
}