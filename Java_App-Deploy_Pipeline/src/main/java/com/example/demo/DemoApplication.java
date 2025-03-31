package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Spring Boot application.
 */
@SpringBootApplication
public final class DemoApplication {  // Marked final to prevent inheritance

    // Private constructor to prevent instantiation
    private DemoApplication() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Main method to launch the Spring Boot application.
     *
     * @param args Command-line arguments (must be final)
     */
    public static void main(final String[] args) {  // Made args final
        SpringApplication.run(DemoApplication.class, args);
    }
}
