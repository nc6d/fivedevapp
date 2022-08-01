package com.service.filesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FilesserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilesserviceApplication.class, args);
	}

}
