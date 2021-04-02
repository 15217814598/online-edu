package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.pojo.Schedule;
import com.edu.onlineedu.pojo.Student;
import com.edu.onlineedu.pojo.Teacher;
import com.edu.onlineedu.service.StudentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "学生接口")
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ApiOperation("获取全部学生")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Student.class)})
    @GetMapping("get_all")
    public Result getAllStudent(@RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        PageInfo pageInfo = studentService.getAllStudent(pageNum, pageSize);
        return Result.success("查询成功", pageInfo);
    }

    @ApiOperation(value = "按条件获取全部学生")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Schedule.class)})
    @PostMapping("get_all")
    public Result getAllTeacher(@RequestBody Map<String, Object> conditions) {
        PageInfo<Student> pageInfo = studentService.getAllStudent(conditions);
        return Result.success("查询成功", pageInfo);
    }

    @ApiOperation(value = "添加学生")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Student.class)})
    @PostMapping("add")
    public Result addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return Result.success("添加成功", null);
    }

    @ApiOperation(value = "删除学生")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Student.class)})
    @DeleteMapping("delete/{id}")
    public Result deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return Result.success("添加成功", null);
    }

    @ApiOperation(value = "修改学生信息")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Student.class)})
    @PutMapping("update")
    public Result updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return Result.success("添加成功", null);
    }
}
