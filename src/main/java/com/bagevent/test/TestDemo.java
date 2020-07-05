package com.bagevent.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bagevent.service.TestService;
import com.bagevent.service.impl.TestServiceImpl;


public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService testService = (TestService) ac.getBean("testServiceImpl");
		testService.test();
	}

}
