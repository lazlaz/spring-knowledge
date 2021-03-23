package com.laz.mybatis.plus.knowledge.person.service.impl;

import com.laz.mybatis.plus.knowledge.person.entity.Person;
import com.laz.mybatis.plus.knowledge.person.mapper.PersonMapper;
import com.laz.mybatis.plus.knowledge.person.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laz
 * @since 2021-03-23
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
