package com.mf.ssm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ��Controller�ķ���������ʹ�ô�ע�⣬�÷�����ӳ��ʱ��ע�뵱ǰ��¼��User����
 * @see com.scienjus.authorization.resolvers.CurrentUserMethodArgumentResolver
 * @author ScienJus
 * @date 2015/7/31.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}
