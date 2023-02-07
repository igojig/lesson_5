package ru.gojig.cloud.front.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FrontApp {
    public static void main(String[] args) {
        SpringApplication.run(FrontApp.class, args);
    }
}
