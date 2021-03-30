package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {

    List<Teacher> getAllTeacher();

    List<Teacher> getAllTeacherByConditions(Map<String, Object> conditions);

    @Insert("insert into teacher (teacher_name, teacher_title, teacher_exp, teacher_phone, teacher_email) " +
            "values (#{teacherName}, #{teacherTitle}, #{teacherExp}, #{teacherPhone}, #{teacherEmail})")
    void addTeacher(Teacher teacher);

    @Delete("delete from teacher where teacher_id = #{id}")
    void deleteTeacher(Integer id);

    @Update("update teacher set " +
            "teacher_name = #{teacherName}, teacher_title = #{teacherTitle}, teacher_exp = #{teacherExp}, teacher_phone = #{teacherPhone}, teacher_email = #{teacherEmail} " +
            "where teacher_id = #{teacherId}")
    void updateTeacher(Teacher teacher);
}
