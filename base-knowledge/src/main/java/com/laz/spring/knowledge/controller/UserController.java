package com.laz.spring.knowledge.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laz.spring.knowledge.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("user")
@Api("userController相关api")
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
	@ApiOperation("获取用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="header",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna")
    })
    @ApiResponses({
        @ApiResponse(code=400,message="请求参数没填好"),
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
	public Object listAll(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		return userService.listAll(page, size);
	}
}
