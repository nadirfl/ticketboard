package com.example.ticketboard.controller;

import com.example.ticketboard.data.HealthCheck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HealthController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/healthCheck")
    public HealthCheck healthCheck(@RequestParam(defaultValue = "World") String name) {
        return new HealthCheck(counter.incrementAndGet(), template.formatted(name));
    }
}
