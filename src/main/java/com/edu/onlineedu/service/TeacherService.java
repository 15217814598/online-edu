package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.TeacherMapper;
import com.edu.onlineedu.pojo.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public PageInfo getAllTeacher(int pageNum, int pageSize) {
        //logger.info(conditions.toString());
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> list = teacherMapper.getAllTeacher();
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public void addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    public void deleteTeacher(Integer id) {
        teacherMapper.deleteTeacher(id);
    }

    public void updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    public PageInfo<Teacher> getAllTeacher(Map<String, Object> conditions) {
        Integer pageNum = conditions.containsKey("pageNum") ? (Integer) conditions.get("pageNum") : 1;
        Integer pageSize = conditions.containsKey("pageSize") ? (Integer) conditions.get("pageNum") : 10;
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> list = teacherMapper.getAllTeacherByConditions(conditions);
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
