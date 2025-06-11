package com.example.javaems;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
    info = @Info(
        title = "EMS API",
        version = "1.0",
        description = "Employee Management System API Documentation"
    )
)

@SpringBootApplication
public class JavaemsApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaemsApplication.class, args);
    }
}
