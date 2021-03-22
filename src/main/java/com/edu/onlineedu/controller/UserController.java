package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.pojo.Login;
import com.edu.onlineedu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @GetMapping("login")
    private Result login(@RequestBody Login user) {
        if (user.getName() == null || user.getPwd() == null) {
                return new Result(false, "账号或密码不能为空");
        }
        Login user1 = userService.fingByName(user);
        logger.warn(user1.toString());
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
}
