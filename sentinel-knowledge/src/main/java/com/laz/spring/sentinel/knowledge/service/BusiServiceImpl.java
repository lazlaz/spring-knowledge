package com.laz.spring.sentinel.knowledge.service;

import org.springframework.stereotype.Service;

@Service
public class BusiServiceImpl {

	public void doBusi() {
		System.out.println("执行业务逻辑  "+Thread.currentThread().getName()+"  ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
