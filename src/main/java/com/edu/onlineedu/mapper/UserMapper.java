package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByName(String username);
}
