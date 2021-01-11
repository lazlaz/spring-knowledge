package com.laz.spring.shardingsphere.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.laz.spring.shardingsphere.dataobject.OrderDO;

@Repository
public interface OrderMapper {

    OrderDO selectById(@Param("id") Integer id);

    List<OrderDO> selectListByUserId(@Param("userId") Integer userId);

    void insert(OrderDO order);

	List<OrderDO> selectByName(@Param("name") String name);

}
