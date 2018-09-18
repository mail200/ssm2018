package com.mf.ssm.token.authorization.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import com.mf.ssm.config.Constants;
import com.mf.ssm.pojo.UserToken;
import com.mf.ssm.service.UserTokenService;
import com.mf.ssm.utils.DateFormatUtil;
import com.mf.ssm.utils.RedisUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

/**
 * 通过Redis存储和验证token的实现类
 * 
 * @see com.scienjus.authorization.manager.TokenManager
 * @author ScienJus
 * @date 2015/7/31.
 */
@Component
public class RedisTokenManager implements TokenManager {

	 @Autowired
	 private UserTokenService userTokenService;
	 
	private RedisTemplate<Long, String> redis;

	@Autowired
	public void setRedis(RedisTemplate redis) {
		
		this.redis = redis;
		
		// 泛型设置成Long后必须更改对应的序列化方案
		redis.setKeySerializer(new JdkSerializationRedisSerializer());
	}

	public UserToken createToken(long userId) {
		// 使用uuid作为源token
		String token = UUID.randomUUID().toString().replace("-", "");
		
		UserToken model = new UserToken(userId, token,
				String.valueOf(Constants.TOKEN_EXPIRES_SECONDS));
		
		
		//userTokenService.insertUserToken(model);
		// 存储到redis并设置过期时间
		redis.boundValueOps(userId).set(token, Constants.TOKEN_EXPIRES_SECONDS, TimeUnit.MILLISECONDS);
		return model;
	}

	public UserToken getToken(String authentication) {
		if (authentication == null || authentication.length() == 0) {
			return null;
		}
		String[] param = authentication.split("_");
		if (param.length != 2) {
			return null;
		}
		// 使用userId和源token简单拼接成的token，可以增加加密措施
		long userId = Long.parseLong(param[0]);
		String token = param[1];
		return new UserToken(userId, token,
				String.valueOf(Constants.TOKEN_EXPIRES_SECONDS));
	}

	public boolean checkToken(UserToken model) {
		if (model == null) {
			return false;
		}
		String token = redis.boundValueOps(model.getId()).get();
		if (token == null || !token.equals(model.getToken())) {
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redis.boundValueOps(model.getId()).expire(
				Constants.TOKEN_EXPIRES_HOUR, TimeUnit.SECONDS);
		return true;
	}

	public void deleteToken(long userId) {
		redis.delete(userId);
	}

	
	@Override
	public Map<String, Object> getToken(long userId) {
		Map<String, Object> tokenInfo = new HashMap<String, Object>();
		tokenInfo.put("token", redis.boundValueOps(userId).get());
		tokenInfo.put("expire", redis.boundValueOps(userId).getExpire());//秒
		long time= redis.boundValueOps(userId).getExpire()*1000 ;//毫秒
		tokenInfo.put("expire_ch",DateFormatUtil.parseMillisecone(time));
		return tokenInfo;
	}

	@Override
	public void setTokenExpire(long userId, String dateStr) {
		Date startDate=new Date();//当前时间
		Date endDate=null;
		try {
			endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		redis.boundValueOps(userId).expire(DateFormatUtil.getDifference(startDate, endDate, 0)*1000, TimeUnit.MILLISECONDS);
	}
}
