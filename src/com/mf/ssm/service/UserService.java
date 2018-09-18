package com.mf.ssm.service;

import java.util.List;

import com.mf.ssm.pojo.User;

public interface UserService {

	// 通过用户名及密码核查用户登录
    public User checkLogin(String username, String password);
    
    public User findByUsername(String username);
    
    public List<User> getUserInfo();
    
}
