package com.example.circuitaservice;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RetryService {

    @Retry(name = "retryApiMethod", fallbackMethod = "retryFallbackMethod")
    public String retryMethod() {
        log.info("retryMethod.");
        throw new RuntimeException();
    }

    public String retryFallbackMethod(Exception ex) {
        log.info("retryFallbackMethod");
        return ex.getMessage();
    }
}
