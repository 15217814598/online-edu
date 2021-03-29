package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    @Select("select * from class")
    List<Schedule> getAllClass();
}
