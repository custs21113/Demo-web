package com.bagevent.service.impl;

import org.springframework.stereotype.Service;

import com.bagevent.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Override
	public void test() {
		System.out.println("AOP≤‚ ‘===============");
	}
}
