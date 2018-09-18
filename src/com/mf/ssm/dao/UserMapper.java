package com.mf.ssm.dao;

import java.util.List;

import com.mf.ssm.pojo.User;

public interface UserMapper {
	
	public User getUserByName(String username);
	
	public List<User> getUserInfo();
}
