package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.ScheduleMapper;
import com.edu.onlineedu.pojo.Schedule;
import com.edu.onlineedu.pojo.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    public PageInfo<Schedule> getAllSchedule(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Schedule> list = scheduleMapper.getAllSchedule();
        PageInfo<Schedule> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public void addSchedule(Schedule schedule) {
        scheduleMapper.addSchedule(schedule);
    }

    public void deleteSchedule(Integer id) {
        scheduleMapper.deleteSchedule(id);
    }

    public void updateSchedule(Schedule schedule) {
        scheduleMapper.updateSchedule(schedule);
    }

    public PageInfo<Schedule> getAllSchedule(Map<String, Object> conditions) {
        Integer pageNum = conditions.containsKey("pageNum") ? (Integer) conditions.get("pageNum") : 1;
        Integer pageSize = conditions.containsKey("pageSize") ? (Integer) conditions.get("pageNum") : 10;
        PageHelper.startPage(pageNum, pageSize);
        List<Schedule> list = scheduleMapper.getAllSchedulesByConditions(conditions);
        PageInfo<Schedule> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
