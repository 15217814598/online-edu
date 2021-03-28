package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Classes;
import com.edu.onlineedu.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper {
    @Select("select * from class")
    List<Classes> getAllClass();
}
