package com.mf.ssm.service;

import java.util.List;

import com.mf.ssm.pojo.User;

public interface UserService {

	// ͨ���û���������˲��û���¼
    public User checkLogin(String username, String password);
    
    public User findByUsername(String username);
    
    public List<User> getUserInfo();
    
}
