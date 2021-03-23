package com.laz.mybatis.plus.knowledge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.laz.mybatis.plus.knowledge.mapper")
public class MybatisPlusApplication {
	public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
