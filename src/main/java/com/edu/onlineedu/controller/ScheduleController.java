package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Schedule;
import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.pojo.Teacher;
import com.edu.onlineedu.service.ScheduleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "课程接口")
@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @ApiOperation(value = "获取全部课程")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Schedule.class)})
    @GetMapping("get_all")
    public Result getAllSchedule(@RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        PageInfo<Schedule> pageInfo = scheduleService.getAllSchedule(pageNum, pageSize);
        return Result.success("查询成功", pageInfo);
    }

    @ApiOperation(value = "按条件获取全部课程")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Schedule.class)})
    @PostMapping("get_all")
    public Result getAllTeacher(@RequestBody Map<String, Object> conditions) {
        PageInfo<Schedule> pageInfo = scheduleService.getAllSchedule(conditions);
        return Result.success("查询成功", pageInfo);
    }

    @ApiOperation(value = "添加课程")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Schedule.class)})
    @PostMapping("add")
    public Result addSchedule(@RequestBody Schedule schedule) {
        scheduleService.addSchedule(schedule);
        return Result.success("添加成功", null);
    }

    @ApiOperation(value = "删除课程")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Schedule.class)})
    @DeleteMapping("delete/{id}")
    public Result deleteSchedule(@PathVariable Integer id) {
        scheduleService.deleteSchedule(id);
        return Result.success("删除成功", null);
    }

    @ApiOperation(value = "更新课程")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Schedule.class)})
    @PutMapping("update")
    public Result updateSchedule(@RequestBody Schedule schedule) {
        scheduleService.updateSchedule(schedule);
        return Result.success("更新成功", null);
    }
}
