package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * Service class providing business logic.
 */
@Service
public class HelloService {

    /**
     * Retrieves a message.
     * @return message as String.
     */
    public String getMessage() {
        return "Hello from Service!";
    }
}
