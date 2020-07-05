package com.bagevent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bagevent.entity.UserLoginLog;
import com.bagevent.repository.UserLoginLogRepository;
import com.bagevent.service.UserLoginLogService;
@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {
	
	@Autowired
	UserLoginLogRepository userLoginLogRepository;
	
	

	@Override
	public List<UserLoginLog> getUserLoginLogByUserId(long user_id) {
		
		return userLoginLogRepository.getUserLoginLogByUserId(user_id);
	}



	@Override
	public Long saveUserLoginLog(UserLoginLog userLoginLog) {
		
		return userLoginLogRepository.save(userLoginLog);
	}

}
