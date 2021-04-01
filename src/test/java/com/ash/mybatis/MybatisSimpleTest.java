package com.ash.mybatis;

import com.ash.BaseMybatisSimpleTest;
import com.ash.mybatis.entity.User;
import com.ash.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


import java.io.IOException;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName MybatisSimpleTest.java
 * @createTime 2021年03月29日 10:52
 * @Description Mybatis 简单的测试
 */
@Slf4j
public class MybatisSimpleTest extends BaseMybatisSimpleTest {

    @Test
    public void select() throws IOException {
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            User user = sqlSession.selectOne("com.ash.mybatis.mapper.UserMapper.selectById", 1);
            System.out.println(user);

            // 第二种用法
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user1 = mapper.selectById(1);
            System.out.println(user1);
        } finally {
            // 关闭连接
            sqlSession.close();
        }
    }




}
