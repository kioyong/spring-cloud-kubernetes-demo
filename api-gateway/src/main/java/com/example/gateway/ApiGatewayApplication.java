package com.example.gateway;

import com.example.gateway.clients.LocationClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableFeignClients
@AllArgsConstructor
@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    private final LocationClient locationClient;

    @GetMapping("/api/greeting")
    String hello() {
        return locationClient.hello();
    }

    @GetMapping("/location/count")
    public Long count() {
        return locationClient.count();
    }

    @GetMapping("/hostname")
    public String hostname() {
        return locationClient.hostname();
    }
}
