package com.laz.spring.knowledge.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {
	 /**
     * 根目录，所有人都可以访问
     * @return
     */
    @RequestMapping("/")
    public String helloSpringBoot() {
        return "hello spring boot";
    }
    
    /**
     * 只有经过身份认证后才可以访问
     * @return
     */
    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }
    
    /**
     * 经过身份认证且身份必须是ADMIN才可以访问，并且是在方法执行前进行验证
     * @return
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/role")
    public String role() {
        return "admin auth";
    }
}
