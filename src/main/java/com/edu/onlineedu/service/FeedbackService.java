package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.FeedbackMapper;
import com.edu.onlineedu.pojo.Feedback;
import com.edu.onlineedu.pojo.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;

    public PageInfo<Feedback> getAllFeedbacks(Map<String, Object> conditions) {
        Integer pageNum = conditions.containsKey("pageNum") ? (Integer) conditions.get("pageNum") : 1;
        Integer pageSize = conditions.containsKey("pageSize") ? (Integer) conditions.get("pageNum") : 10;
        PageHelper.startPage(pageNum, pageSize);
        List<Feedback> list = feedbackMapper.getAllFeedbacks();
        PageInfo<Feedback> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
