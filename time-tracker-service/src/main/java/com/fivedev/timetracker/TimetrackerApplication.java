package com.fivedev.timetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimetrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetrackerApplication.class, args);
	}

}
