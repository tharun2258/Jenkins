package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Spring Boot application.
 */
@SpringBootApplication
public final class DemoApplication {  // Made class final

    // Private constructor to prevent instantiation
    private DemoApplication() {
        throw new UnsupportedOperationException("Utility class");
    }
