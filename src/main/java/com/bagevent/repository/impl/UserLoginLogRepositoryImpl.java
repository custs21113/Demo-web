package com.bagevent.repository.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bagevent.entity.User;
import com.bagevent.entity.UserLoginLog;
import com.bagevent.repository.UserLoginLogRepository;
@Repository
public class UserLoginLogRepositoryImpl implements UserLoginLogRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	
	@Override
	public List<UserLoginLog> getUserLoginLogByUserId(long user_id) {
		SQLQuery query=getCurrentSession().createSQLQuery("select * from UserLoginLog where user_id =?");
		query.setParameter(0, user_id);
		query.addEntity(UserLoginLog.class);
		List<UserLoginLog> list=query.list();
		System.out.println(33);
		System.out.println(list);
		return list;
	}


	@Override
	public Long save(UserLoginLog userLoginLog) {
		
		return (Long) getCurrentSession().save(userLoginLog);
	}

}
