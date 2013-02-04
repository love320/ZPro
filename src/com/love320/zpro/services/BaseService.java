package com.love320.zpro.services;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.love320.zpro.bean.Filter;
import com.love320.zpro.bean.Page;
import com.love320.zpro.utils.HibernateUtils;
import com.love320.zpro.utils.ReflectionUtils;

//抽象基础服务类
public abstract class BaseService<T> {

	@Autowired
	protected JdbcTemplate jdbc;

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected T add(T obj){
		Session session = getSession();
		session.save(obj);
		return obj;
	}
	
	protected T get(Long id){
		Session session = getSession();
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return (T) session.get(entity, id);
	}
	
	protected boolean update(T obj){
		Session session = getSession();
		session.update(obj);
		return true;
	}
	
	protected boolean delete(T obj){
		Session session = getSession();
		session.delete(obj);
		return true;
	}
	
	protected Page find(Page page,Class entity,List<Filter> filters){
		Criterion[] criterions = HibernateUtils.buildCriterionByFilter(filters);
		return find(page,entity,criterions);
	}
	
	protected Page find(Page page,List<Filter> filters){
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		Criterion[] criterions = HibernateUtils.buildCriterionByFilter(filters);
		return find(page,entity,criterions);
	}
	
	protected Page find(Page page){
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return find(page,entity);
	}
	
	protected Page find(Page page,Class entity,Criterion... criterions){
		Criteria criteria = getSession().createCriteria(entity);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		Long count = (Long)criteria.setProjection(Projections.rowCount()).uniqueResult();//总条数
		page.setCount(count.intValue());
		
	    criteria = getSession().createCriteria(entity);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		int start = page.getSize() <= 1 ? 0 : (page.getIndex()-1) * page.getPagesize(); 
		List list = criteria.setFirstResult(start).setMaxResults(page.getPagesize()).list();
		page.setList(list);
		return page;
	}
	
	

}
