package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Spring Boot application.
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * Entry point of the application.
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
