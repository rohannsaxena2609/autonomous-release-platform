package com.rohan.autonomous_release_platform;

import com.rohan.autonomous_release_platform.dto.ApplicationResponse;
import com.rohan.autonomous_release_platform.model.Application;
import com.rohan.autonomous_release_platform.repository.ApplicationRepository;
import com.rohan.autonomous_release_platform.service.ApplicationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceTests {

    @Mock
    private ApplicationRepository repository;

    @InjectMocks
    private ApplicationService service;

    @Test
    void shouldReturnAllApplications() {

        Application application = Application.builder()
                .id(1L)
                .name("Release Platform")
                .version("1.0.0")
                .owner("Rohan")
                .repositoryUrl("https://github.com/rohan/release-platform")
                .status("CREATED")
                .createdAt(LocalDateTime.now())
                .build();

        when(repository.findAll()).thenReturn(List.of(application));

        List<ApplicationResponse> result = service.getAllApplications();

        assertEquals(1, result.size());
        assertEquals("Release Platform", result.get(0).getName());
        assertEquals("1.0.0", result.get(0).getVersion());
    }
}