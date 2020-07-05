package com.bagevent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagevent.entity.User;
import com.bagevent.repository.UserRepository;
import com.bagevent.service.UserService;
import com.bagevent.utils.MD5_salt;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public Long saveUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public User loadUser(Long id) {
		return (User)userRepository.get(id);
	}
	@Override
	public User checkUser(String user_name) {
		return userRepository.getUserByUser_Name(user_name);
	}
	@Override
	public User login(String user_name,String password) {
		return userRepository.login(user_name,password);
	}
	@Override
	public User checkUserByCellphone(String cellphone) {
		return userRepository.getUserByCellphone(cellphone);
	}
	@Override
	public User checkUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}
	@Override
	public User getUserByBoth(String cellphone, String email) {
		return userRepository.getUserByBoth(cellphone, email);
	}

	
	
}
