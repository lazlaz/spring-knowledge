package com.laz.spring.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.laz.spring.shardingsphere.mapper")
public class Application {
}
