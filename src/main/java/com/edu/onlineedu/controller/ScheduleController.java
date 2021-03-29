package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Schedule;
import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.service.ScheduleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "课程接口")
@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService classService;

    @ApiOperation(value = "获取全部课程")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Schedule.class)})
    @GetMapping("get_all_class")
    public Result getAllClass(@RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        PageInfo<Schedule> pageInfo = classService.getAllClass(pageNum, pageSize);
        return Result.success("查询成功", pageInfo);
    }
}
