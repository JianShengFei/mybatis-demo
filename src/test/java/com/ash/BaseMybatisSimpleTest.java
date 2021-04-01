package com.ash;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.InputStream;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @Description
 * @ClassName BaseSimpleTest.java
 * @createTime 2021年03月31日 14:25
 */
@Slf4j
public class BaseMybatisSimpleTest {

    protected SqlSession sqlSession;

    @Before
    public void before(){
        InputStream inputStream = null;

        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        try {
            inputStream = Resources.getResourceAsStream(resource);
        }catch (Exception e){
            log.info("读取配置失败", e);
        }
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
    }

}
