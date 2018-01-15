package com.cur1osity.trelloservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TrelloserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrelloserviceApplication.class, args);
	}
}
