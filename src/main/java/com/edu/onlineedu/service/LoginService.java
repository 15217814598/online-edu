package com.edu.onlineedu.service;

import com.edu.onlineedu.mapper.LoginMapper;
import com.edu.onlineedu.pojo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired(required = false)
    private LoginMapper userMapper;

    public Login fingByName(Login user) {
        return userMapper.findByName(user.getName());
    }

    public void addLogin(Login login) {
        userMapper.addLogin(login);
    }

    public void deleteLogin(Integer id) {
        userMapper.deleteLogin(id);
    }

    public void updateLogin(Login login) {
        userMapper.updateLogin(login);
    }
}
