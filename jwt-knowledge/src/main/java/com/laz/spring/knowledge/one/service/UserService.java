package com.laz.spring.knowledge.one.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laz.spring.knowledge.one.model.User;

@Service("UserService")
public class UserService {
	Map<String, User> users = new HashMap<String, User>();

	public UserService() {
		User user = new User();
		user.setId("1");
		user.setUsername("laz");
		user.setPassword("laz");
		users.put(user.getId(),user);
	}

	public User findByUsername(User user){
		for (String k:users.keySet()) {
			if (users.get(k).getUsername().equals(user.getUsername())) {
				return users.get(k);
			}
		}
		return null;
    }

	public User findUserById(String userId) {
		return users.get(userId);
	}
}
