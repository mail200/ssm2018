package com.mf.ssm.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.ssm.dao.UserMapper;
import com.mf.ssm.pojo.User;
import com.mf.ssm.service.UserService;

public class UserServiceImpl  implements UserService {
	
	//注解引用Mapper类资源
	@Autowired
	UserMapper userMap;
	
	@Override
	public User checkLogin(String username, String password) {
		
		//根据用户名实例化用户对象
        User user = userMap.getUserByName(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		//根据用户名实例化用户对象
        User user = userMap.getUserByName(username);
        
        return user;
	}

	@Override
	public List<User> getUserInfo() {
		// TODO Auto-generated method stub
		return userMap.getUserInfo();
	}
}
