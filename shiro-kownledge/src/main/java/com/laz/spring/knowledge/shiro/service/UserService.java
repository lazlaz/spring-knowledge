package com.laz.spring.knowledge.shiro.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.laz.spring.knowledge.shiro.model.User;

@Service("UserService")
public class UserService {
	Map<Integer, User> users = new HashMap<Integer, User>();

	public UserService() {
		User user = new User();
		user.setId(1);
		user.setUserName("laz");
		user.setPassword("02f3e8e3af98293f81d703dd4ee26db2");
		users.put(user.getId(),user);
	}

	public User findByUserName(String userName){
		for (Integer k:users.keySet()) {
			if (users.get(k).getUserName().equals(userName)) {
				return users.get(k);
			}
		}
		return null;
    }

	public User findUserById(String userId) {
		return users.get(userId);
	}
}
