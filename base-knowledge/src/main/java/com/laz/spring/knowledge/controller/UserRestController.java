package com.laz.spring.knowledge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laz.spring.knowledge.domain.User;
import com.laz.spring.knowledge.service.UserService2;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

	@Autowired
	private UserService2 userService;
	public UserService2 getUserService() {
		return userService;
	}
	@PostMapping("/test1")
	public boolean test1(@RequestBody User user) {
		System.out.println("请求参数:" + user);
		try {
			userService.test1(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}