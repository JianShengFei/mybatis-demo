package com.ash.mybatis.mapper;

import com.ash.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @createTime 2021年03月29日 10:37
 * @Description TODO 请标注类具体的用途
 */
public interface UserMapper {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectById(Integer id);

}
