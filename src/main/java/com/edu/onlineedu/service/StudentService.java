package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.StudentMapper;
import com.edu.onlineedu.pojo.Student;
import com.edu.onlineedu.pojo.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public PageInfo<Student> getAllStudent(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentMapper.getAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }

    public PageInfo<Student> getAllStudent(Map<String, Object> conditions) {
        Integer pageNum = conditions.containsKey("pageNum") ? (Integer) conditions.get("pageNum") : 1;
        Integer pageSize = conditions.containsKey("pageSize") ? (Integer) conditions.get("pageNum") : 10;
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list = studentMapper.getAllTeacherByConditions(conditions);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);
    }

    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }
}
