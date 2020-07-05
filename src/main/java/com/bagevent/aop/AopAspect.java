package com.bagevent.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bagevent.entity.User;
import com.bagevent.entity.UserLoginLog;
import com.bagevent.service.UserLoginLogService;
@Component
@Aspect
public class AopAspect {
	@Autowired
	UserLoginLogService userLoginLogService;
	
	@Autowired
	public HttpServletRequest request;
	
	//execution(* com.bagevent.service.impl.TestServiceImpl.test(..))
	@Before("execution(* com.bagevent.service.impl.UserServiceImpl.login(..))")
	public void before() {
		System.out.println("ǰ��֪ͨ��=========");
	}

	@AfterReturning(value = "execution(* com.bagevent.service.impl.UserServiceImpl.login(..))", returning = "returnVal")
	public void atferReturning(Object returnVal) {
		User user=(User)returnVal;
		if(user!=null) {
			String login_ip=request.getRemoteAddr();
			UserLoginLog userLoginLog=new UserLoginLog();
			userLoginLog.setUser_id(user.getUser_id());
			userLoginLog.setLogin_time(new Date());
			userLoginLog.setLogin_ip(login_ip);
			userLoginLogService.saveUserLoginLog(userLoginLog);
			System.out.println();
			System.out.println("����֪ͨ>>>>>>>>>>>>" + returnVal);
		}
		else {
			System.out.println("AOP��׽���쳣");
		}
//		System.out.println(user.toString());

	}

	@Around("execution(* com.bagevent.service.impl.UserServiceImpl.login(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("����֪ͨǰ....");
		Object obj = (Object) joinPoint.proceed();
		System.out.println("����֪ͨ��....");
		return obj;
	}

	@AfterThrowing(value = "execution(* com.bagevent.service.impl.UserServiceImpl.login(..))", throwing = "e")
	public void afterThrowable(Throwable e) {
		System.out.println("�����쳣:msg=" + e.getMessage());
	}

	/**
	 * ����ʲô����¶���ִ�еķ���
	 */
	@After(value = "execution(* com.bagevent.service.impl.UserServiceImpl.login(..))")
	public void after() {
		System.out.println("����֪ͨ....");
	}

}
