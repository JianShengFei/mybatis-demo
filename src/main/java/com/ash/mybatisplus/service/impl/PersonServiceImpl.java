package com.ash.mybatisplus.service.impl;


import com.ash.mybatisplus.entity.Person;
import com.ash.mybatisplus.mapper.PersonMapper;
import com.ash.mybatisplus.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jianshengfei
 * @since 2021-03-30
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
