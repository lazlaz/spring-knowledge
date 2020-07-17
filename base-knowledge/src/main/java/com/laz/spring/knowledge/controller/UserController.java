package com.laz.spring.knowledge.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laz.spring.knowledge.service.UserService;
@RestController
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 查询全部
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@GetMapping("/listAll")
	public Object listAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		return userService.listAll(page, size);
	}
}
