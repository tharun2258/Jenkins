package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling API requests.
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * Returns a greeting message.
     * @return greeting message as String.
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
