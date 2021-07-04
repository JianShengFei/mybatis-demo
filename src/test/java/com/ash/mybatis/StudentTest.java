package com.ash.mybatis;

import cn.hutool.json.JSONUtil;
import com.ash.mybatis.entity.Student;
import com.ash.mybatis.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName StudentTest
 * @Description simple test
 * @Author jianshengfei
 * @Date 2021/7/4 0:55
 */
public class StudentTest {

    private SqlSession session;

    private StudentMapper mapper;

    @Before
    public void before() throws IOException {
        // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 然后根据 sqlSessionFactory 得到 session
        session = sqlSessionFactory.openSession();

        // 获取mapper映射
        mapper = session.getMapper(StudentMapper.class);
    }

    @After
    public void after() {
        session.commit();
    }

    @Test
    public void testSelect() {
        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> listStudent = session.selectList("list");
        for (Student student : listStudent) {
            System.out.println(JSONUtil.toJsonStr(student));
        }
    }

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setName("简圣勇");
        student.setAge(25);
        student.setSex(1);
        student.setAddress("贵州省遵义市外环路富丽东方");
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        session.insert("insert", student);
    }

    @Test
    public void testUpdate(){
        Student student = new Student();
        student.setId(2L);
        student.setName("简易枫");
        student.setAge(24);
        student.setSex(1);
        student.setAddress("广东省广州市天河区新塘新街新园新村C区7号");
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        session.update("updateById", student);
    }

    @Test
    public void testDelete(){
        session.delete("deleteById", 4L);
    }

    @Test
    public void testListByMapper(){

        List<Student> list = mapper.list();
        for (Student student : list) {
            System.out.println(JSONUtil.toJsonStr(student));
        }
    }

    @Test
    public void testInsertByMapper(){
        Student student = new Student();
        student.setName("简圣勇");
        student.setAge(25);
        student.setSex(1);
        student.setAddress("贵州省遵义市外环路富丽东方");
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        mapper.insert(student);
    }

    @Test
    public void testUpdateByMapper(){
        Student student = new Student();
        student.setId(5L);
        student.setName("简圣勇");
        student.setAge(21);
        mapper.updateById(student);
    }

    @Test
    public void testDeleteByMapper(){
        mapper.deleteById(5L);
    }



}
