package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.StudentMapper;
import com.edu.onlineedu.pojo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public PageInfo getAllStudent(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentMapper.getAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }
}
