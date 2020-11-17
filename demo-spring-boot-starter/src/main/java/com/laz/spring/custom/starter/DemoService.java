package com.laz.spring.custom.starter;

public class DemoService {
	public String sayWhat;
	public String toWho;

	public DemoService(String sayWhat, String toWho) {
		this.sayWhat = sayWhat;
		this.toWho = toWho;
	}

	public String say() {
		return this.sayWhat + "!  " + toWho;
	}
}
