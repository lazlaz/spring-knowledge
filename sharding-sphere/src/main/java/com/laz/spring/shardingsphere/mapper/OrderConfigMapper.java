package com.laz.spring.shardingsphere.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.laz.spring.shardingsphere.dataobject.OrderConfigDO;

@Repository
public interface OrderConfigMapper {

	OrderConfigDO selectById(@Param("id") Integer id);

}