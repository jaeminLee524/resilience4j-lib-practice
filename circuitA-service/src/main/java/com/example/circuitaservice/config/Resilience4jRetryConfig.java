package com.example.circuitaservice.config;


import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Resilience4jRetryConfig {

    private final RetryRegistry retryRegistry;

    @Bean
    public Retry retry() {
        return retryRegistry.retry(
            "retryApiMethod",
            RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(3000))
                .build()
        );
    }
}
