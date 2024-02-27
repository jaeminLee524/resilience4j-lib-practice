package com.example.circuitaservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CircuitBreakerController {

    private final CircuitBClient circuitBClient;

    @CircuitBreaker(name = "circuitApiMethod")
    @GetMapping("/api/v1/circuit")
    public String circuitApi() {
        return circuitBClient.getDelay();
    }
}
