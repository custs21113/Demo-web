package com.bagevent.controller;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bagevent.entity.Message;
import com.bagevent.entity.User;

import com.bagevent.service.TestService;
import com.bagevent.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private TestService testService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		//	        实际返回的是views/test.jsp ,spring-mvc.xml中配置过前后缀
		return "test";
	}

//	@RequestMapping(value = "/springtest", method = RequestMethod.GET)
//	public String springTest() {
//		System.out.println("springtest");
//		return testService.test();
//	}
//	
	
	@RequestMapping(value = "/save",method=RequestMethod.GET)
	@ResponseBody
	public String loadUser() {
		
		System.out.println(userService.loadUser((long)4));
		return "success!";
	}
//	@RequestMapping(value = "/login.do",method=RequestMethod.GET)
//	public String login(@RequestParam("username")String username,@RequestParam("password")String password,Model model,RedirectAttributes attr) {
//		
//		System.out.println(username+"         "+password);
//		User user=userService.login(username, password);
//		System.out.println("UC====="+user);
//		if(user!=null) {
//			attr.addFlashAttribute("user_id",user.getUser_id());
//			return "redirect:loginHistory";
//		}
////			return "redirect:/ut/"+user.getUser_id();
//		else
//			return "loginFail";
//	}
	@RequestMapping(value = "/login.do",method=RequestMethod.GET)
	public String login(@RequestParam("username")String username,@RequestParam("password")String password,HttpServletRequest request) {
		
		System.out.println(username+"         "+password);
		if(username!=null&&!"".equals(username)&&password!=null&&!"".contentEquals(password)) {
			User user=userService.login(username, password);
			System.out.println(user);
			if(user!=null) {
				request.setAttribute("user_id", user.getUser_id());
				request.setAttribute("state", 100);
				return "forward:loginHistory";
			}
			else
				return "loginFail";
			
		}
		else
			return "loginFail";
	}
	
	
//	public String register(@RequestParam("username")String username,@RequestParam("password")String password) {
//		System.out.println(username+"         "+password);
//		return "success!";
//		
//	}
	public Message register(User user) {
		System.out.println(user);
		User u=userService.checkUser(user.getUser_name());
		System.out.println(u);
		if(u==null) {
			Date create_time=new Date();
			user.setCreate_time(create_time);
			userService.saveUser(user);
			return Message.success();
		}
		else
			return Message.fail();
	}
	@RequestMapping(value="/register.do",method=RequestMethod.POST)
	@ResponseBody
	public Message register_Both(User user) {
		User u_b=userService.getUserByBoth(user.getCellphone(),user.getEmail());
		Date create_time=new Date();
		if(user.getUser_name()==null||"".equals(user.getUser_name())) {
			user.setUser_name("user"+new Random().nextInt(999999));
		}
		user.setCreate_time(create_time);
		System.out.println("110========="+user.getUser_name());
		if(u_b!=null) {
			userService.saveUser(user);
			return Message.success();
		}else
			return Message.fail();
	}
	
	public Message checkUserByCellphone(@RequestParam("cellphone")String cellphone) {
		User user=userService.checkUserByCellphone(cellphone);
		if(user==null)return Message.success();
		else return Message.fail();
	}
	
	public Message checkUserByEmail(@RequestParam("email")String email) {
		User u_e=userService.checkUserByCellphone(email);
		if(u_e==null)return Message.success();
		else return Message.fail();
	}
	
}
