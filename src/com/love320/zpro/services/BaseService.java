package com.love320.zpro.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class BaseService {

	@Autowired
	protected JdbcTemplate jdbc;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
