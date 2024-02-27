package com.example.circuitaservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "circuitB")
public interface CircuitBClient {

    @RequestMapping(method = RequestMethod.GET, value = "http://api/v1/delay:8091")
    String getDelay();
}
