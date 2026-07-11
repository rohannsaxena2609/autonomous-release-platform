package com.rohan.autonomous_release_platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class VersionController {

    @GetMapping("/version")
    public Map<String, Object> version() {

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("application", "Autonomous Release Orchestration Platform");
        response.put("version", "1.0.0");
        response.put("environment", "Development");
        response.put("javaVersion", System.getProperty("java.version"));
        response.put("serverTime", LocalDateTime.now());

        return response;
    }
}