package com.love320.zpro.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.love320.zpro.bean.Page;

//基础服务类
public class BaseService {

	@Autowired
	protected JdbcTemplate jdbc;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Object add(Object obj){
		Session session = getSession();
		session.save(obj);
		return obj;
	}
	
	public boolean update(Object obj){
		Session session = getSession();
		session.update(obj);
		return true;
	}
	
	public boolean delete(Object obj){
		Session session = getSession();
		session.delete(obj);
		return true;
	}
	
	public Page find(Page page){
		
		return page;
	}

}
