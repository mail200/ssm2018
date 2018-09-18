package com.mf.ssm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.ssm.dao.UserTokenMapper;
import com.mf.ssm.pojo.UserToken;
import com.mf.ssm.service.UserTokenService;

public class UserTokenServiceImpl  implements UserTokenService {
	
	//注解引用Mapper类资源
	@Autowired
	UserTokenMapper userTokenMap;

	@Override
	public UserToken getUserTokenById(int id) {
		
		UserToken user = userTokenMap.getUserTokenById(id);
        
        return user;
	}

	@Override
	public int insertUserToken(UserToken userToken) {
		int result = userTokenMap.insertUserToken(userToken);
		return result;
	}

	@Override
	public int deleteUserTokenByPrimaryKey(int id) {
		int result = userTokenMap.deleteUserTokenByPrimaryKey(id);
		return result;
	}
	
}
