package com.mf.ssm.service;

import com.mf.ssm.pojo.UserToken;

public interface UserTokenService {

    UserToken getUserTokenById(int id);
	
	int insertUserToken(UserToken userToken);
	
	int deleteUserTokenByPrimaryKey(int id);
    
}
