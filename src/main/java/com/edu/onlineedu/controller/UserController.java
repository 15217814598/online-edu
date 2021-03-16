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

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    private Result login(@RequestBody User user) {
        Result result = new Result();
        if (user.getUsername() == null || user.getPassword() == null) {
            result.setStatus(false);
            result.setMessage("账号密码不能为空");
            return result;
        }
        User user1 = userService.fingByName(user);
        if (user1 == null) {
            result.setStatus(false);
            result.setMessage("账号不存在");
            return result；
        }
        if (user1.getPassword() != user.getPassword()) {
            return
        }
    }
}
