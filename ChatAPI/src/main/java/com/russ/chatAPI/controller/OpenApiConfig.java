package com.russ.chatAPI.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new Info().title("CHAT API")
                                .version("1.0.0")
                                .description(" TEST CHAT API")
                                .contact(new Contact()
                                        .name("Russel")
                                        .email("yellarussel@gmail.com")) 
                                        
                                
                        		);
                    }
    }
