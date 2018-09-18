package com.mf.ssm.pojo;

import java.util.Date;

import com.mf.ssm.utils.DateFormatUtil;

public class UserToken {

    //�û�id
    private long id;

    //������ɵ�uuid
    private String token;
    
    private String expires;//tokenʧЧʱ��
    
    private long expiresIn;

    public UserToken(long id, String token,String millise) {
        this.id = id;
        this.token = token;
        this.expires= DateFormatUtil.add(new Date(), "yyyy-MM-dd HH:mm:ss", Long.valueOf(millise));
        this.expiresIn= DateFormatUtil.addLong(new Date(), "yyyy-MM-dd HH:mm:ss", Long.valueOf(millise));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		this.expires = expires;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

}
