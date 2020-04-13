package com.example.gateway.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "arch-location-service")
public interface LocationClient {

    @GetMapping
    String hello();

    @GetMapping("count")
    Long count();

    @GetMapping("/hostname")
    String hostname();
}
