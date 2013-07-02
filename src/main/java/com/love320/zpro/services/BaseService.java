package com.love320.zpro.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	protected JdbcTemplate jdbc;//纯JDBC

	@Autowired
	private SessionFactory sessionFactory;//hiberante Session

	//子类获取session
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//添加
	protected T add(T obj){
		Session session = getSession();
		session.save(obj);
		return obj;
	}
	
	//指定ID获取对象
	protected T get(Long id){
		Session session = getSession();
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return (T) session.get(entity, id);
	}
	
	//更新对象
	protected boolean update(T obj){
		Session session = getSession();
		session.update(obj);
		return true;
	}
	
	//删除对象
	protected boolean delete(T obj){
		Session session = getSession();
		session.delete(obj);
		return true;
	}
	
	//保存与更新对象、自动判断
	protected boolean saveOrUdate(T obj){
		Session session = getSession();
		session.saveOrUpdate(obj);
		return true;
	}
	
	//获取Criteria中声明的信息总条数
	protected Long count(Criteria criteria){
		return  (Long)criteria.setProjection(Projections.rowCount()).uniqueResult();//总条数
	}
	
	/** List * */
	
	//获取所有信息列表
	protected List list(){
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return list(entity,null,null);
	}
	
	//指定排序规则并获取所有信息列表
	protected List list(String orderBy, String order){
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return list(entity,orderBy,order);
	}
	
	//指定实体类和排序规则并获取所有信息列表
	protected List list(Class entity,String orderBy, String order){
		Criteria criteria = getSession().createCriteria(entity);
		if(orderBy != null && order != null){
			HibernateUtils.criteriaByOrder(criteria, orderBy, order);//排序规则
		}
		return criteria.list();
	}
	
	//获取Criteria的列表
	protected List list(Criteria criteria){
		return  criteria.list();
	}
	
	//指定Criteria并获取所有信息起始点
	protected List list(Criteria criteria,int start,int size){
		return  criteria.setFirstResult(start).setMaxResults(size).list();//设置分页
	}
	
	//指定where(Map)条件获取所有信息列表
	protected  List list(Map parameterMap){
		List<Filter> filters = Filter.parse(parameterMap);
		return list(filters);
	}
	
	//指定实体和where(Map)条件获取所有信息列表
	protected  List list(Class entity,Map parameterMap){
		List<Filter> filters = Filter.parse(parameterMap);
		return list(entity,filters);
	}
	
	//指定where(Filter)条件获取所有信息列表
	protected List list(List<Filter> filters){
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return list(entity, filters);
	}
	
	//指定实体和where(Filter)条件获取所有信息列表
	protected List list(Class entity,List<Filter> filters){
		return list(entity,null,null, filters);
	}
	
	//指定实体和where(Filter)条件、排序规则获取所有信息列表
	protected List list(Class entity,String orderBy ,String order,List<Filter> filters){
		Criterion[] criterions = HibernateUtils.buildCriterionByFilter(filters);
		return list(entity, orderBy, order, criterions);
	}
	
	//指定实体和where(Criterion)条件、排序规则获取所有信息列表
	protected List list(Class entity,String orderBy ,String order,Criterion... criterions){
		Criteria criteria = getSession().createCriteria(entity);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		HibernateUtils.criteriaByOrder(criteria, orderBy,order);//排序规则
		return list(criteria);
	}

	/** List End * */
	
	/** Page  **/
	
	//指定实体，返回分页数据对象
	protected Page find(Class entity,Page page){
		List<Criterion> criterionList = new ArrayList<Criterion>();
		return find(entity,page,criterionList.toArray(new Criterion[criterionList.size()]));
	}
	
	//指定实体和where(Map)条件，返回分页数据对象
	protected Page find(Class entity,Page page,Map parameterMap){
		List<Filter> filters = Filter.parse(parameterMap);
		page.setP(parameterMap);
		return find(entity,page,filters);
	}
		
	//指定实体和where(Filter)条件，返回分页数据对象
	protected Page find(Class entity,Page page,List<Filter> filters){
		Criterion[] criterions = HibernateUtils.buildCriterionByFilter(filters);
		return find(entity,page,criterions);
	}
	
	//指定实体和where(Criterion)条件，返回分页数据对象
	protected Page find(Class entity,Page page,Criterion... criterions){
		Criteria criteria = getSession().createCriteria(entity);
		Criteria criteriaCount = getSession().createCriteria(entity);
		for (Criterion c : criterions) {
			criteria.add(c);
			criteriaCount.add(c);
		}
		page.setCount(count(criteriaCount).intValue());//设置总数

		HibernateUtils.criteriaByOrder(criteria, page.getOrderBy(), page.getOrder());//排序规则
		int start = page.getSize() <= 1 ? 0 : (page.getIndex()-1) * page.getPagesize(); 
		page.setList(list(criteria,start,page.getPagesize()));
		return page;
	}
	
	//返回默认分页数据对象
	protected Page find(){
		Page page = new Page<T>();
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return find(entity,page);
	}
	
	//返回分页数据对象
	protected Page find(Page page){
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return find(entity,page);
	}
	
	//指定where(Map)条件，返回分页数据对象
	protected Page find(Page page,Map parameterMap){
		List<Filter> filters = Filter.parse(parameterMap);
		page.setP(parameterMap);
		return find(page,filters);
	}
	
	//指定where(Filter)条件，返回分页数据对象
	protected Page find(Page page,List<Filter> filters){
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		Criterion[] criterions = HibernateUtils.buildCriterionByFilter(filters);
		return find(entity,page,criterions);
	}
	
	//指定where(Criterion)条件，返回分页数据对象
	protected Page find(Page page,Criterion... criterions){
		Class<T> entity = ReflectionUtils.getSuperClassGenricType(getClass());
		return find(entity,page,criterions);
	}
	
	/** Page End **/

}
