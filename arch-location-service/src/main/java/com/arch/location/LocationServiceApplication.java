package com.arch.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class LocationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationServiceApplication.class, args);
    }

    private final AtomicLong atomicLong = new AtomicLong();

    @GetMapping("/count")
    public Long count() {
        return atomicLong.incrementAndGet();
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, name = "name", defaultValue = "world") String name) {
        return "hello ".concat(name);
    }

    @GetMapping("/hostname")
    public String hostname() {
        return System.getProperty("host");
    }
}
