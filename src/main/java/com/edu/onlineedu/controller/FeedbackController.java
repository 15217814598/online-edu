package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Enrecord;
import com.edu.onlineedu.pojo.Feedback;
import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.service.FeedbackService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @ApiOperation(value = "按条件获取全部feedback")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Feedback.class)})
    @PostMapping("get_all")
    public Result getAllTeacher(@RequestBody Map<String, Object> conditions) {
        PageInfo<Feedback> pageInfo = feedbackService.getAllFeedbacks(conditions);
        return Result.success("查询成功", pageInfo);
    }
}
