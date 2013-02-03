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
	

}
