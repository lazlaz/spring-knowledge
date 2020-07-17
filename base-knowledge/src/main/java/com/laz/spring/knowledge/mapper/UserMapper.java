package com.laz.spring.knowledge.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.laz.spring.knowledge.domain.User;

@Mapper
public  interface UserMapper {

    @Select({
            "select * from user"
    })
    List<User> listAll();

}
