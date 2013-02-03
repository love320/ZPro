package com.love320.zpro.bean;

import java.util.List;

public class Page<T> {
	
    public T entity;
	
    /** 基础信息 **/
	//当前页
	protected Integer index;
	//每页条数 
	protected Integer pagesize;
	//总条数
	protected Integer count;
	//总页数
	protected Integer size;
	//信息列表 
	protected List<T> list;
	
	/** 查询条件信息 **/
	//sql
	String hql;
	//查询条件

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
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
	
	

}
