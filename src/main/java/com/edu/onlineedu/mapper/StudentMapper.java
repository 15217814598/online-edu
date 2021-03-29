package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student")
    List<Student> getAllStudent();

    @Insert("insert into student " +
            "(student_name, student_age, student_time, student_phone, student_email) " +
            "values (#{studentName}, #{studentAge}, #{studentTime}, #{studentPhone}, #{studentEmail})")
    void addStudent(Student student);

    @Delete("delete from student where student_id = #{id}")
    void deleteStudent(Integer id);

    @Update("update student " +
            "set student_name = #{studentName}, student_age = #{studentAge}, student_time = #{studentTime}, student_phone = #{studentPhone}, student_email = #{studentEmail} " +
            "where student_id = #{student_id}")
    void updateStudent(Student student);
}
