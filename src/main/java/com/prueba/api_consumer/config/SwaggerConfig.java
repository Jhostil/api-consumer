package com.prueba.api_consumer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Aplicacion para consumir API externa",
                description = "Aplicación que consume una API de usuarios y los expone mediante un endpoint"
        )
)
public class SwaggerConfig {
}
