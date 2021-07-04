package com.ash.mybatis.mapper;

import com.ash.mybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName StudentMapper
 * @Description test mybatis
 * @Author jianshengfei
 * @Date 2021/7/4 10:28
 */
@Mapper
public interface StudentMapper {

    int insert(Student student);

    int deleteById(Long id);

    int updateById(Student student);

    List<Student> list();


}
