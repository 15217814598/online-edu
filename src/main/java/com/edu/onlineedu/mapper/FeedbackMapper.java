package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Feedback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FeedbackMapper {
    List<Feedback> getAllFeedbacks(Map<String, Object> conditions);
}
