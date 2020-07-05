package com.bagevent.service;

import com.bagevent.entity.User;

public interface UserService {
	Long saveUser(User user);
	User loadUser(Long id);
	User checkUser(String user_name);
	User login(String user_name,String password);
	User checkUserByCellphone(String cellphone);
	User checkUserByEmail(String email);
	User getUserByBoth(String cellphone,String email);
}
