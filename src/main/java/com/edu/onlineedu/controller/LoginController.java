package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.pojo.Login;
import com.edu.onlineedu.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Api(tags = "用户接口")
@RestController
public class LoginController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Login.class)})
    @PostMapping("login")
    public Result login(@RequestBody Login user) {
        if (user.getName() == null || user.getPwd() == null) {
                return new Result(false, "账号或密码不能为空");
        }
        Login user1 = loginService.fingByName(user);
        if (user1 == null) {
            return new Result(false, "账号不存在");
        }
        if (!Objects.equals(user.getPwd(), user1.getPwd())) {
            return new Result(false, "密码错误");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("name", user1.getName());
        return new Result(true, "登录成功", data);
    }

    @ApiOperation(value = "注册")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Login.class)})
    @PostMapping("register")
    public Result register(@RequestBody Login login) {
        loginService.addLogin(login);
        return Result.success("注册成功", null);
    }

    @ApiOperation(value = "删除用户")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Login.class)})
    @DeleteMapping("user/delete")
    public Result deleteLogin(Integer id) {
        loginService.deleteLogin(id);
        return Result.success("删除成功", null);
    }

    @ApiOperation(value = "更新用户")
    @ApiResponses({@ApiResponse(code=200, message = "success", response = Login.class)})
    @DeleteMapping("user/update")
    public Result updateLogin(Login login) {
        loginService.updateLogin(login);
        return Result.success("修改成功", null);
    }
}
