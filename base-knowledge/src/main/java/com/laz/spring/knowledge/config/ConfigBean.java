package com.laz.spring.knowledge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConfigBean {
	@Autowired
	private  Environment environment;
	
	public void getConfig() {
		System.out.println(environment.getProperty("spring.profiles.active"));
		System.out.println(environment.getProperty("server.port"));
	}
}
