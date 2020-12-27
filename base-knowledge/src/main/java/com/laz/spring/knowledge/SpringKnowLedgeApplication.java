package com.laz.spring.knowledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringKnowLedgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKnowLedgeApplication.class, args);
	}

}
