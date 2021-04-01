package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.EnrecordMapper;
import com.edu.onlineedu.pojo.Enrecord;
import com.edu.onlineedu.pojo.Feedback;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EnrecordService {
    @Autowired
    private EnrecordMapper enrecordMapper;

    public PageInfo<Enrecord> getAllEnrecords(Map<String, Object> conditions) {
        Integer pageNum = conditions.containsKey("pageNum") ? (Integer) conditions.get("pageNum") : 1;
        Integer pageSize = conditions.containsKey("pageSize") ? (Integer) conditions.get("pageNum") : 10;
        PageHelper.startPage(pageNum, pageSize);
        List<Enrecord> list = enrecordMapper.getAllEnercord();
        PageInfo<Enrecord> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
