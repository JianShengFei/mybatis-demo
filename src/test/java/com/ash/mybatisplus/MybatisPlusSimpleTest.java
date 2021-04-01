package com.ash.mybatisplus;


import cn.hutool.json.JSONUtil;
import com.ash.BaseMybatisSimpleTest;
import com.ash.mybatisplus.entity.Person;
import com.ash.mybatisplus.mapper.PersonMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;

import java.util.List;


/**
 * @author jianshengfei
 * @version 1.0.0
 * @Description TODO 请标注类具体的用途
 * @ClassName MybatisPlusSimpleTest.java
 * @createTime 2021年03月30日 17:48
 */
public class MybatisPlusSimpleTest extends BaseMybatisSimpleTest {

    @Test
    public void select(){
        /*
            说明：没有配置mybatis-plus相关信息，扫描出mybatis-plus实现的方法
            当使用mybatis-plus现有方法查询时，会报找不到方法
            so，需在mapper.xml文件编写sql
            真捞呀，不想写了...
         */
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.selectById(18);
        System.out.println(JSONUtil.toJsonStr(person));
        List list = mapper.selectList(new QueryWrapper());
        for (Object o : list) {
            System.out.println(JSONUtil.toJsonStr(o));
        }
    }

}
