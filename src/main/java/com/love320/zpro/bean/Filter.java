package com.love320.zpro.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;

/** 前台参数转换为Filter对象集 *_*/
public class Filter {
	
	/** 条件符 *_*/
	public enum Operator {
		EQ, LIKE, GT, LT, GE, LE
	}
	
	/** 数据类型 *_*/
	public enum Property {
		S(String.class), I(Integer.class), L(Long.class), N(Double.class), D(Date.class), B(Boolean.class);
		private Class<?> clazz;
		private Property(Class<?> clazz) { this.clazz = clazz; }
		public Class<?> getValue() { return clazz; }
	}
	
	private String name; //字段名
	private String[] names;//字段集
	private Object value;//数据
	private Operator operator;//条件符
	
	/** 构造 *_*/
	public Filter(String fieldName, Operator operator, Object value) {
		this.name = fieldName;
		this.value = value;
		this.operator = operator;
	}
	
	/** 构造并处理 *_*/
	public Filter(String name,Object value){
			this.name = StringUtils.substringBefore(name, "_"); //字段名
			String type = StringUtils.substringAfterLast(name, "_");//运算符 or 类型
			String operatorType = type.substring(0, type.length()-1);//运算符 
			operator = Enum.valueOf(Operator.class, operatorType);//赋值条件运算符
			String  propertyType = type.substring( type.length()-1, type.length());//类型
			Class<?> propertyClass = Enum.valueOf(Property.class, propertyType).getValue();//获取数据类型
			this.value = ConvertUtils.convert(value, propertyClass);//转型并赋值数据
			
			String nameStr = StringUtils.substringBeforeLast(name, "_");//处理 多条件 "或" OR
			this.names = StringUtils.splitByWholeSeparator(nameStr,"_OR_");//赋值多个字段名
	}
	
	/** 静态公共方式 *_*/
	public static List<Filter> parse(Map<String, Object> map) {
		List<Filter> listFilter = new ArrayList<Filter>();
		Set<String> keys = map.keySet();//键值集
		for(String key : keys){
			//判断类型是否满足
			if(key.split("_").length >= 2 && !key.substring(0, 1).equals("_")) listFilter.add(new Filter(key,map.get(key)));//实例并装载	
		}
		return listFilter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}
	
	
	public boolean isMany(){
		return names != null && names.length > 1 ? true:false;
	}
	
	
	
	
	
	

}
