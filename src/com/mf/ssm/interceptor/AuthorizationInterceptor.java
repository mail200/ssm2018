package com.mf.ssm.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import com.mf.ssm.annotation.Authorization;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mf.ssm.config.Constants;
import com.mf.ssm.pojo.UserToken;
import com.mf.ssm.token.authorization.manager.TokenManager;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * @see com.scienjus.authorization.annotation.Authorization
 * @author ScienJus
 * @date 2015/7/30.
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger(String.valueOf(AuthorizationInterceptor.class));
	
    @Autowired
    private TokenManager manager;
    
	 /**
	  * 
	  * @param request
	  * @param response
	  * @param handler
	  * @return
	  * @throws Exception
	  */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
    	
    	logger.info("preHandle-->is start");
    	System.out.print("^^^^^^^^^^^^^/preHandle^^^^^^^^^^^^^^^^^^^^^");
    	return true;
//        //如果不是映射到方法直接通过
//        if (!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//        
//        //从header中得到token
//        String authorization = request.getHeader(Constants.AUTHORIZATION);
//        authorization="1_81d3779fce804169888cc3b21f00fe06";
//        
//        //验证token
//        UserToken model = manager.getToken(authorization);
//        if (manager.checkToken(model)) {
//            //如果token验证成功，将token对应的用户id存在request中，便于之后注入
//            //request.setAttribute(Constants.CURRENT_USER_ID, model。);
//            return true;
//        }
//        
//        //如果验证token失败，并且方法注明了Authorization，返回401错误
//        if (method.getAnnotation(Authorization.class) != null) {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//        return true;
    }
}
