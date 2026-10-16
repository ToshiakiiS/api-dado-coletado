package com.github.toshiakiis.api_dado_coletado_silvio_556716_m2.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Dado Coletado - Sondas Espaciais")
                        .version("1.0.0")
                        .description("API REST para registro e gerenciamento de dados coletados por sondas espaciais - Checkpoint 2 (Microservices)")
                        .contact(new Contact()
                                .name("Silvio Toshiaki Kawano")
                                .email("rm556716@fiap.com.br")));
    }
}
