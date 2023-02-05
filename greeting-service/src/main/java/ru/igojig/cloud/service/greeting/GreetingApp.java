package ru.igojig.cloud.service.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient - !!!!
@EnableDiscoveryClient
@RestController
public class GreetingApp {
    @Autowired
    private RestTemplate restTemplate;



    public static void main(String[] args) {
        SpringApplication.run(GreetingApp.class, args);
    }

    @GetMapping("/api/v1/greetings")
    public String getGreetings() {
        return "Hello my friend!!!";
    }

    @GetMapping("/api/v1/greetings/slowed")
    public String getSlowGreetings(@RequestParam(name = "delay", defaultValue = "0") Long delay) {
        String data = restTemplate.getForObject("http://slow-service/api/v1/slow?delay={delay}", String.class, delay);
//        String data = restTemplate.getForObject("http://localhost:63641/api/v1/slow", String.class);
//        String data = restTemplate.getForObject("http://slow-service/api/v1/slow", String.class);
        return "Hello my friend: " + data;
    }
}
