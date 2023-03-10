package ru.igojig.cloud.service.slow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient //@EnableEurekaClient - !!!
@RestController
public class SlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(SlowApplication.class, args);
    }

    @GetMapping("/api/v1/slow")
    public String getData(@RequestParam(defaultValue = "0") Long delay) throws InterruptedException {
        Thread.sleep(delay);
        return "Slow Data: " + delay;
    }
}
