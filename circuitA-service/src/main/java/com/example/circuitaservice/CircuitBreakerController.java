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

    private final CircuitBreakerService circuitBreakerService;
    private final CircuitBClient circuitBClient;

    @CircuitBreaker(name = "circuitApiMethod", fallbackMethod = "fallbackMethod")
    @GetMapping
    public String circuitApi() {
        String result = callBService();

        circuitBreakerService.extractLog();

        return result;
    }

    private String callBService() {
        log.info("start call B service");
        String delay = circuitBClient.getDelay();
        log.info("end call B service");

        return delay;
    }

    private String fallbackMethod(Throwable throwable) {
        log.info(">>>>>> fallback. message: {}", throwable.getMessage());
        return throwable.getMessage();
    }
}
