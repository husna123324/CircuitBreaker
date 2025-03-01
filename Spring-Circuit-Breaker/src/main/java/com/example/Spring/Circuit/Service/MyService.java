package com.example.Spring.Circuit.Service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);
    private static final String CIRCUIT_BREAKER_NAME = "slowService";

    @CircuitBreaker(name = CIRCUIT_BREAKER_NAME, fallbackMethod = "fallbackData")
    public String fetchData() {
        logger.error("Simulating service failure...");
        throw new RuntimeException("Service is down"); // Simulating failure
    }

    public String fallbackData(Exception e) { 
        logger.warn("Fallback method triggered due to: {}", e.getMessage());
        return "Fallback response: Service is currently unavailable. Please try again later.";
    }
}