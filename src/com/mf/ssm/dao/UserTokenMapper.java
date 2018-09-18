package com.mf.ssm.dao;

import com.mf.ssm.pojo.UserToken;

public interface UserTokenMapper {
	
	UserToken getUserTokenById(int id);
	
	int insertUserToken(UserToken userToken);
	
	int deleteUserTokenByPrimaryKey(int id);
}
