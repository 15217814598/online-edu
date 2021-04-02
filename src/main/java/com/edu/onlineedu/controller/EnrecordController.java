package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Enrecord;
import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.service.EnrecordService;
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
@RequestMapping("/enrecord")
public class EnrecordController {
    @Autowired
    private EnrecordService enrecordService;

    @ApiOperation(value = "按条件获取全部Enrecord")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Enrecord.class)})
    @PostMapping("get_all")
    public Result getAllTeacher(@RequestBody Map<String, Object> conditions) {
        PageInfo<Enrecord> pageInfo = enrecordService.getAllEnrecords(conditions);
        return Result.success("查询成功", pageInfo);
    }
}
