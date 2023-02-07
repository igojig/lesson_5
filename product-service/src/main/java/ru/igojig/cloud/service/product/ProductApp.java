package ru.igojig.cloud.service.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class ProductApp {
    public static void main(String[] args) {
        SpringApplication.run(ProductApp.class, args);
    }
}
