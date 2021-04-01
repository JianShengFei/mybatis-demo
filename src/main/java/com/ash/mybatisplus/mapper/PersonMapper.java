package com.ash.mybatisplus.mapper;


import com.ash.mybatisplus.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jianshengfei
 * @since 2021-03-30
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {

}
