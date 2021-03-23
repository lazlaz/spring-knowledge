package com.laz.mybatis.plus.knowledge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laz.mybatis.plus.knowledge.mapper.UserMapper;
import com.laz.mybatis.plus.knowledge.model.User;

import org.junit.Assert;

@RestController
public class UserController {
	@Autowired
	UserMapper mapper;
	
	//spring接近一个接口多个bean时，方法
	@Autowired   
	@Qualifier("test1")   
	ITest test;

	@GetMapping("/select")
	public void select() {
		List<User> userList = mapper.selectList(null);
		Assert.assertEquals(5, userList.size());
		userList.forEach(System.out::println);
		
		test.test();
	}
}
