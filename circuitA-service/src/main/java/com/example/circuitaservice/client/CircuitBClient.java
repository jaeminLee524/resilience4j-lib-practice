package com.example.circuitaservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "circuitB", url = "http://localhost:8091")
public interface CircuitBClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/delay")
    String getDelay();
}
