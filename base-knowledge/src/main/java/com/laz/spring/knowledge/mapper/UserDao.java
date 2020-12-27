package com.laz.spring.knowledge.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.laz.spring.knowledge.domain.User;

@Mapper
public interface UserDao {
	@Select({
        "select * from user where id=#{id}"
})
	String findById(@Param("id") long id);
	 @Insert("INSERT INTO user (id, name, password) VALUES (#{id}, #{username}, #{password})")
	void insert(User user);

}
