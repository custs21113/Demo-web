package com.bagevent.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bagevent.entity.UserLoginLog;
import com.bagevent.service.UserLoginLogService;

@Controller
public class UserLoginLogController {
	
	@Autowired
	UserLoginLogService userLoginLogService;
	@Autowired
	public HttpServletRequest request;
	
//	@RequestMapping(value = "/ut/{user_id}", method = RequestMethod.GET)
//	@RequestMapping(value = "/loginHistory", method = RequestMethod.GET)
//	@ResponseBody
//
////	public String test(HttpSession session,HttpServletRequest request) {
//	public String test() {
//		//	        实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
//		List<UserLoginLog> userLoginLogs=userLoginLogService.getUserLoginLogByUserId((long)12);
//		System.out.println(userLoginLogs);
//		request.setAttribute("userLoginLogs", userLoginLogs);
//		
//		return "loginHistory";
//	}
	
	@RequestMapping(value = "/loginHistory", method = RequestMethod.GET)
	public String loginHistory(HttpServletRequest request) {
		List<UserLoginLog> userLoginLogs=userLoginLogService.getUserLoginLogByUserId((long) request.getAttribute("user_id"));
		System.out.println("ULLC===="+userLoginLogs);
		request.setAttribute("userLoginLogs", userLoginLogs);
		System.out.println("转发成功");
		return "loginHistory";
	}
}
