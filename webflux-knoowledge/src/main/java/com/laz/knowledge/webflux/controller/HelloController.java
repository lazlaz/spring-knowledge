package com.laz.knowledge.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laz.knowledge.webflux.entiy.User;

import reactor.core.publisher.Mono;


@RestController
public class HelloController {

	 @GetMapping("/hello")
	    public String hello() {
	        return "Hello, WebFlux !";
	    }

	    @GetMapping("/user")
	    public Mono<User> getUser() {
	        User user = new User();
	        user.setName("犬小哈");
	        user.setDesc("欢迎关注我的公众号: 小哈学Java");
	        return Mono.just(user);
	    }
}
