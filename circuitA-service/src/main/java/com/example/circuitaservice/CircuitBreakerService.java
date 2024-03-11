package com.example.circuitaservice;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CircuitBreakerService {

    private final CircuitBreakerRegistry circuitBreakerRegistry;

    public void extractLog() {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("circuitApiMethod");
        circuitBreaker.getEventPublisher()
            .onSuccess(event -> log.info("success call A Method. eventType: {}, circuitBreakerStatus: {}", event.getEventType(), circuitBreaker.getState()))
            .onError(event -> log.error("fail call A Method. eventType: {}, circuitBreakerStatus: {}", event.getEventType(), circuitBreaker.getState()))
            .onIgnoredError(event -> log.info("ignore Exception occurred. eventType: {}, circuitBreakerStatus: {}", event.getEventType(), circuitBreaker.getState()))
            .onReset(event -> log.info("state is reset. eventType: {}, circuitBreakerStatus: {}", event.getEventType(), circuitBreaker.getState()))
            .onStateTransition(event -> log.info("change state result : {}", event.getStateTransition()));
    }
}
