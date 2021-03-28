package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.ClassMapper;
import com.edu.onlineedu.pojo.Classes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassMapper classMapper;

    public PageInfo<Classes> getAllClass(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Classes> list = classMapper.getAllClass();
        PageInfo<Classes> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
