package com.laz.spring.sentinel.knowledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApplication {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(SentinelApplication.class, args);
	}
}
