package com.bagevent.repository.impl;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bagevent.entity.User;
import com.bagevent.repository.UserRepository;
import com.bagevent.utils.MD5_salt;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}

	@Override
	public User get(Long id) {
		return (User) getCurrentSession().get(User.class, id);
	}

	@Override
	public Long save(User user) {
		String afterMD5AndSalt=MD5_salt.generate(user.getPassword());
		String salt = MD5_salt.salt(afterMD5AndSalt);
		user.setPassword(afterMD5AndSalt);
		user.setSalt(salt);
		return (Long) getCurrentSession().save(user);
	}

	@Override
	public User getUserByUser_Name(String user_name) {

		String sql = "select * from user where user_name= ?";
		SQLQuery query = getCurrentSession().createSQLQuery(sql);
		query.setParameter(0, user_name);
		query.addEntity(User.class);
		User user = (User) query.uniqueResult();
		getCurrentSession().close();
		return user;
	}

	@Override
	public User login(String user_name, String password) {
		SQLQuery query = getCurrentSession().createSQLQuery("select * from user where user_name=?");
		query.setParameter(0, user_name);
		query.addEntity(User.class);
		User user = (User) query.uniqueResult();
		System.out.println("user  is NULL 55");
		String salt= user.getSalt();
		String saltPassword=user.getPassword();
		Boolean flag=MD5_salt.verify(password,saltPassword);
		if(flag) {
			user.setPassword(password);
			getCurrentSession().close();
			return user;
		}
		else {
			getCurrentSession().close();
			return null;
		}
	}

	@Override
	public User getUserByCellphone(String cellphone) {
		SQLQuery query=getCurrentSession().createSQLQuery("select * from user where cellphone = ?");
		query.setParameter(0, cellphone);
		query.addEntity(User.class);
		System.out.println(75);
		return (User)query.uniqueResult();
	}

	@Override
	public User getUserByEmail(String email) {
		SQLQuery query = getCurrentSession().createSQLQuery("select *  from user where email = ?");
		query.setParameter(0, email);
		query.addEntity(User.class);
		System.out.println(84);
		return (User)query.uniqueResult();
	}
	@Override
	public User getUserByBoth(String cellphone,String email) {
		SQLQuery query = getCurrentSession().createSQLQuery("select * from user where cellphone = ? and email = ?");
		query.setParameter(0, cellphone);
		query.setParameter(1, email);
		query.addEntity(User.class);
		System.out.println(93);
		return (User) query.uniqueResult();
	}
}
