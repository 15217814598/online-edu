package com.edu.onlineedu.mapper;

import com.edu.onlineedu.pojo.Feedback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedbackMapper {
    List<Feedback> getAllFeedbacks();
}
