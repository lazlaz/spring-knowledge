package com.laz.spring.knowledge.shiro.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	 private static final long serialVersionUID = -5440372534300871944L;
	    
    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private String status;
}
