package com.example.Spring.Circuit.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring.Circuit.Service.MyService;


@RestController
@RequestMapping("/api") // Base path for the API
public class CircuitBreakerController {

    private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    private final MyService myService;

    public CircuitBreakerController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/data")
    public String fetchData() {
        logger.info("Received request to fetch data...");
        try {
            return myService.fetchData();
        } catch (Exception e) {
            logger.error("Error while fetching data: {}", e.getMessage());
            return "An error occurred. Please try again later.";
        }
    }
}