package com.rohan.autonomous_release_platform;

import com.rohan.autonomous_release_platform.controller.ApplicationController;
import com.rohan.autonomous_release_platform.service.ApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApplicationController.class)
class ApplicationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationService applicationService;

    @Test
    void shouldReturnStatus200() throws Exception {

        when(applicationService.getAllApplications()).thenReturn(List.of());

        mockMvc.perform(get("/api/applications"))
                .andExpect(status().isOk());
    }
}