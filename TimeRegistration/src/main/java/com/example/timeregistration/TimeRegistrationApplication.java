package com.example.timeregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimeRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeRegistrationApplication.class, args);
    }

}
