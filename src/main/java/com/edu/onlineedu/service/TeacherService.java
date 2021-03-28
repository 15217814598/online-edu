package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.TeacherMapper;
import com.edu.onlineedu.pojo.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public PageInfo getAllTeacher(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> list = teacherMapper.getAllTeacher();
        logger.info(list.toString());
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
