package com.bagevent.repository;

import java.util.List;

import com.bagevent.entity.UserLoginLog;

public interface UserLoginLogRepository {
	List<UserLoginLog> getUserLoginLogByUserId(long user_id);

	Long save(UserLoginLog userLoginLog);
}
