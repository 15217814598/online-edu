package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.pojo.Teacher;
import com.edu.onlineedu.service.StudentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("学生接口")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation("获取全部学生")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Teacher.class)})
    @GetMapping("get_all_student")
    public Result getAllStudent(@RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        PageInfo pageInfo = studentService.getAllStudent(pageNum, pageSize);
        return Result.success("查询成功", pageInfo);
    }
}
