package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    Login findByName(String name);
}
