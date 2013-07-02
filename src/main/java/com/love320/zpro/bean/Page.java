package com.love320.zpro.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {
	
    public T entity;
	
    /** 基础信息 **/
	protected int index = 1;//当前页
	protected int pagesize =10;//每页条数 
	protected int count;//总条数
	protected int size;//总页数
	protected List<T> list;//信息列表 
	
	protected String orderBy = null;
	protected String order = null;
	
	/** 查询条件信息 **/
	//查询sql
	String hql;
	//查询条件
	
	/** 附加参数信息 **/
	protected Map p = new HashMap();

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		//已总条数计算总页数
		size = count / pagesize;//整除
		if( count % pagesize > 0) size++;//加1 
		this.count = count;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getHql() {
		return hql;
	}

	public void setHql(String hql) {
		this.hql = hql;
	}

	public Map getP() {
		return p;
	}

	public void setP(Map p) {
		this.p = p;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	

}
