package com.gatewayservicess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServicessApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServicessApplication.class, args);
	}

}
