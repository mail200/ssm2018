package com.mf.ssm.token.authorization.manager;

import java.util.Map;

import com.mf.ssm.pojo.UserToken;

/**
 * ��Token���в����Ľӿ�
 * @author ScienJus
 * @date 2015/7/31.
 */
public interface TokenManager {

    /**
     * ����һ��token������ָ���û�
     * @param userId ָ���û���id
     * @return ���ɵ�token
     */
    public UserToken createToken(long userId);

    /**
     * ���token�Ƿ���Ч
     * @param model token
     * @return �Ƿ���Ч
     */
    public boolean checkToken(UserToken model);

    /**
     * ���ַ����н���token
     * @param authentication ���ܺ���ַ���
     * @return
     */
    public UserToken getToken(String authentication);

    /**
     * ���token
     * @param userId ��¼�û���id
     */
    public void deleteToken(long userId);
    
    /**
     * �����û�id��ȡtoken
     * @param userid �û�id
     * @return
     */
    public Map<String,Object> getToken(long userId);
    
    /** ���û���ʱ��
     * @param userId
     * @param time ��ʽ yyyy-MM-dd HH:mm:ss
     */
    public void setTokenExpire(long userId,String time);

}

