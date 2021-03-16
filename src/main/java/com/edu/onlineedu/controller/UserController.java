package com.edu.onlineedu.controller;

import com.edu.onlineedu.pojo.Result;
import com.edu.onlineedu.pojo.User;
import com.edu.onlineedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    private Result login(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null) {
                return new Result(false, "账号或密码不能为空");
        }
        User user1 = userService.fingByName(user);
        if (user1 == null) {
            return new Result(false, "账号不存在");
        }
        if (user1.getPassword() != user.getPassword()) {
            return new Result(false, "密码错误");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("username", user1.getUsername());
        return new Result(true, "登录成功", data);
    }
}
