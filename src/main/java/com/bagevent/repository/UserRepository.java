package com.bagevent.repository;

import com.bagevent.entity.User;

public interface UserRepository {
	User get(Long id);
	Long save(User user);
	User getUserByUser_Name(String user_name);
	User login(String user_name, String password);
	User getUserByCellphone(String cellphone);
	User getUserByEmail(String email);
	User getUserByBoth(String cellphone, String email);
}
