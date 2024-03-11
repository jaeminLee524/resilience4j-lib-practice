package com.example.circuitaservice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetryControllerTest {

    @Autowired
    private RetryService retryService;

    @DisplayName("Retry 테스트")
    @Test
    void retryMethod() {
        // given
        retryService.retryMethod();

        // when

        // then
    }
}