package com.bagevent.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="userloginlog")
public class UserLoginLog {
	@Id
	@Column(name="login_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long login_id;
	
	@Column(name="user_id")
	private long user_id;
	
	@Column(name="login_time")
	private Date login_time;
	
	@Column(name="login_ip")
	private String login_ip;

	public long getLogin_id() {
		return login_id;
	}

	public void setLogin_id(long login_id) {
		this.login_id = login_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	@Override
	public String toString() {
		return "UserLoginLog [login_id=" + login_id + ", user_id=" + user_id + ", login_time=" + login_time
				+ ", login_ip=" + login_ip + "]";
	}
	
	
}
