package com.laz.spring.knowledge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laz.spring.knowledge.domain.User;
import com.laz.spring.knowledge.mapper.UserDao;
@Service
public class UserService2 {
	@Autowired
	private UserDao udao;
	@Transactional
	public boolean test1(User user) throws Exception {
		long id = user.getId();
		System.out.println("查询的数据1:" + udao.findById(id));
		// 新增两次，会出现主键ID冲突，看是否可以回滚该条数据
		udao.insert(user);
		System.out.println("查询的数据2:" + udao.findById(id));
		//udao.insert(user);
		return false;
	}
}
