package com.laz.mybatis.plus.knowledge.controller;

import org.springframework.stereotype.Component;

@Component
public class Test1 implements ITest{

	@Override
	public void test() {
		System.out.println(Test1.class);
		
	}

}
