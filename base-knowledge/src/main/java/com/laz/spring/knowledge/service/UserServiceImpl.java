package com.laz.spring.knowledge.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.laz.spring.knowledge.domain.User;
import com.laz.spring.knowledge.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Object listAll(int page, int size) {
    	System.out.println(userMapper);
        List<User> userList = userMapper.listAll();
        return userList;
    }


}
