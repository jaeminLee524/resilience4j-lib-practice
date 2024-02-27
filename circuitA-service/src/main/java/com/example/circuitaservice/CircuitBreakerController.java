package com.example.circuitaservice;

import com.example.circuitaservice.client.CircuitBClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CircuitBreakerController {

    private final CircuitBClient circuitBClient;

    @CircuitBreaker(name = "circuitApiMethod", fallbackMethod = "fallbackMethod")
    @GetMapping("/api/v1/circuit")
    public String circuitApi() {
        return circuitBClient.getDelay();
    }

    private String fallbackMethod(Throwable throwable) {
        log.info(">>>>>> fallback. message: {}", throwable.getMessage());
        return throwable.getMessage();
    }
}
