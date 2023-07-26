package com.configservicess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServicessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServicessApplication.class, args);
	}

}
