package com.example.circuitbservice;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DelayController {

    @GetMapping("/api/v1/delay")
    public String delayController() throws InterruptedException {
        Thread.sleep(3000);

        String now = LocalDateTime.now().toString();

        log.info("delayController. now: {}", now);

        return now;
    }
}
