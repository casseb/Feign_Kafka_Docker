package com.bycasseb.appaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppazApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppazApplication.class, args);
	}

}
