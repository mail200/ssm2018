package com.mf.ssm.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.ssm.dao.UserMapper;
import com.mf.ssm.pojo.User;
import com.mf.ssm.service.UserService;

public class UserServiceImpl  implements UserService {
	
	//ע������Mapper����Դ
	@Autowired
	UserMapper userMap;
	
	@Override
	public User checkLogin(String username, String password) {
		
		//�����û���ʵ�����û�����
        User user = userMap.getUserByName(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		//�����û���ʵ�����û�����
        User user = userMap.getUserByName(username);
        
        return user;
	}

	@Override
	public List<User> getUserInfo() {
		// TODO Auto-generated method stub
		return userMap.getUserInfo();
	}
}
