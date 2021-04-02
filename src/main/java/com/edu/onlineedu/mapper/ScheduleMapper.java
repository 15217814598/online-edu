package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Schedule;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScheduleMapper {

    List<Schedule> getAllSchedulesByConditions(Map<String, Object> conditions);

    @Select("select * from schedule")
    List<Schedule> getAllSchedule();

    @Insert("insert into schedule " +
            "(class_name, class_teacher, class_time, is_over, class_period) " +
            "values (#{className}, #{classTeacher}, #{classTime}, #{isOver}, #{classPeriod})")
    void addSchedule(Schedule schedule);

    @Delete("delete from schedule where class_id = #{classId}")
    void deleteSchedule(Integer id);

    @Update("update schedule " +
            "set class_name = #{className}, class_teacher = #{classTeacher}, class_time = #{classTime}, is_over = #{isOver}, class_period = #{classPeriod} " +
            "where class_id = #{classId}")
    void updateSchedule(Schedule schedule);
}
