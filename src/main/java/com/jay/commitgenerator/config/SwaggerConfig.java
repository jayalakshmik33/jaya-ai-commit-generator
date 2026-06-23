package com.jay.commitgenerator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AI Commit Message Generator API")
                        .description("REST API that generates Conventional Commit messages from Git diff using OpenAI")
                        .version("1.0.0")
                        );
    }
}
