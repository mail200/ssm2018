package com.mf.ssm.token.authorization.manager;

import java.util.Map;

import com.mf.ssm.pojo.UserToken;

/**
 * 对Token进行操作的接口
 * @author ScienJus
 * @date 2015/7/31.
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public UserToken createToken(long userId);

    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(UserToken model);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
    public UserToken getToken(String authentication);

    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public void deleteToken(long userId);
    
    /**
     * 根据用户id获取token
     * @param userid 用户id
     * @return
     */
    public Map<String,Object> getToken(long userId);
    
    /** 设置缓存时间
     * @param userId
     * @param time 格式 yyyy-MM-dd HH:mm:ss
     */
    public void setTokenExpire(long userId,String time);

}

