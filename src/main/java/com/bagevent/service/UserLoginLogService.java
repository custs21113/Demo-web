package com.bagevent.service;

import java.util.List;

import com.bagevent.entity.UserLoginLog;

public interface UserLoginLogService {
	List<UserLoginLog> getUserLoginLogByUserId(long user_id);
	Long saveUserLoginLog(UserLoginLog userLoginLog);
}
