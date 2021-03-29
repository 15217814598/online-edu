package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Login;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {

    @Select("select * from login where name = #{name}")
    Login findByName(String name);

    @Insert("insert into login (name, pwd) values (#{name}, #{pwd})")
    void addLogin(Login login);

    @Delete("delete from login where id = #{id}")
    void deleteLogin(Integer id);

    @Update("update login set name = #{name}, pwd = #{pwd} where id = #{id}")
    void updateLogin(Login login);
}
