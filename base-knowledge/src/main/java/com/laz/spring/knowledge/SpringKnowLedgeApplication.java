package com.laz.spring.knowledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringKnowLedgeApplication {

	public static void main(String[] args) throws Exception {
	//	System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\class");
		ConfigurableApplicationContext context = SpringApplication.run(SpringKnowLedgeApplication.class, args);
	}

}
