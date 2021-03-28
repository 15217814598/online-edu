package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher")
    List<Teacher> getAllTeacher();
}
