package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.UserMapper;
import com.edu.onlineedu.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    public Login fingByName(Login user) {
        return userMapper.findByName(user.getName());
    }
}
