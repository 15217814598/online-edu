package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.UserMapper;
import com.edu.onlineedu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User fingByName(User user) {
        return userMapper.findByName(user.getUsername());
    }
}
