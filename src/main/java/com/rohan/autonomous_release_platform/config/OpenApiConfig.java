package com.rohan.autonomous_release_platform.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI autonomousReleaseAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Autonomous Release Orchestration Platform API")

                        .description("Enterprise DevOps Platform built using Spring Boot, Docker, Kubernetes, GitHub Actions, ArgoCD, Prometheus and Grafana.")

                        .version("1.0.0")

                        .contact(new Contact()
                                .name("Rohan Saxena")
                                .email("rohan@example.com"))

                        .license(new License()
                                .name("MIT")))

                .externalDocs(new ExternalDocumentation()

                        .description("GitHub Repository")

                        .url("https://github.com/"));
    }
}