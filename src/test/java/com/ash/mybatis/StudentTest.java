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
        // ���� mybatis-config.xml ���õ���Ϣ�õ� sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // Ȼ����� sqlSessionFactory �õ� session
        session = sqlSessionFactory.openSession();

        // ��ȡmapperӳ��
        mapper = session.getMapper(StudentMapper.class);
    }

    @After
    public void after() {
        session.commit();
    }

    @Test
    public void testSelect() {
        // ���ͨ�� session �� selectList() �������� sql ��� listStudent
        List<Student> listStudent = session.selectList("list");
        for (Student student : listStudent) {
            System.out.println(JSONUtil.toJsonStr(student));
        }
    }

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setName("��ʥ��");
        student.setAge(25);
        student.setSex(1);
        student.setAddress("����ʡ�������⻷·��������");
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        session.insert("insert", student);
    }

    @Test
    public void testUpdate(){
        Student student = new Student();
        student.setId(2L);
        student.setName("���׷�");
        student.setAge(24);
        student.setSex(1);
        student.setAddress("�㶫ʡ����������������½���԰�´�C��7��");
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
        student.setName("��ʥ��");
        student.setAge(25);
        student.setSex(1);
        student.setAddress("����ʡ�������⻷·��������");
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        mapper.insert(student);
    }

    @Test
    public void testUpdateByMapper(){
        Student student = new Student();
        student.setId(5L);
        student.setName("��ʥ��");
        student.setAge(21);
        mapper.updateById(student);
    }

    @Test
    public void testDeleteByMapper(){
        mapper.deleteById(5L);
    }



}
