package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Login;
import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.pojo.Teacher;
import com.edu.onlineedu.service.TeacherService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "教师接口")
@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "获取全部教师")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Teacher.class)})
    @GetMapping("get_all")
    public Result getAllTeacher(@RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        PageInfo<Teacher> pageInfo = teacherService.getAllTeacher(pageNum, pageSize);
        return Result.success("查询成功", pageInfo);
    }

    @ApiOperation(value = "添加教师")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Teacher.class)})
    @PostMapping("add")
    public Result addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return Result.success("添加成功", null);
    }

    @ApiOperation(value = "删除教师")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Teacher.class)})
    @DeleteMapping("delete/{id}")
    public Result deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return Result.success("删除成功", null);
    }

    @ApiOperation(value = "修改教师信息")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Teacher.class)})
    @PutMapping("update")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return Result.success("修改教成功", null);
    }
}
