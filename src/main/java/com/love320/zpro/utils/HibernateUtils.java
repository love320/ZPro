package com.love320.zpro.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.love320.zpro.bean.Filter;
import com.love320.zpro.bean.Filter.Operator;

public class HibernateUtils {
	
	/** 按属性条件列表创建Criterion数组 *_*/
	public static Criterion[] buildCriterionByFilter(final List<Filter> filters) {
		List<Criterion> criterionList = new ArrayList<Criterion>();
		for (Filter filter : filters) {
			if (filter.isMany()) { //多个条件 带 or
				Disjunction disjunction = Restrictions.disjunction();
				for (String param : filter.getNames()) {
					Criterion criterion = buildCriterion(param, filter.getValue(), filter.getOperator());
					disjunction.add(criterion);
				}
				criterionList.add(disjunction);
			} else {//单一条件
				Criterion criterion = buildCriterion(filter.getName(),filter.getValue(),filter.getOperator());
				criterionList.add(criterion);
			}
		}
		return criterionList.toArray(new Criterion[criterionList.size()]);
	}
	
	/** 按属性条件参数创建Criterion *_*/
	public static Criterion buildCriterion(final String name, final Object value, final Operator operator) {
		Criterion criterion = null;
		//根据MatchType构造criterion
		switch (operator) {
		case EQ:
			criterion = Restrictions.eq(name, value);
			break;
		case LIKE:
			criterion = Restrictions.like(name, (String) value, MatchMode.ANYWHERE);
			break;
		case LE:
			criterion = Restrictions.le(name, value);
			break;
		case LT:
			criterion = Restrictions.lt(name, value);
			break;
		case GE:
			criterion = Restrictions.ge(name, value);
			break;
		case GT:
			criterion = Restrictions.gt(name, value);
		}
		
		return criterion;
	}
	
	public static boolean criteriaByOrder(Criteria criteria,String orderBy,String order){
		if(StringUtils.isBlank(orderBy) || StringUtils.isBlank(order)) return false; //判断是否为空
		//分离对象为数组
		String[] orderByArray = StringUtils.split(orderBy, ',');
		String[] orderArray = StringUtils.split(order, ',');
		if(orderByArray.length != orderArray.length ) return false;//排序参数与条件不一至
		
		for(int i = 0 ; i < orderByArray.length;i++){
			if("asc".equals(orderArray[i])) criteria.addOrder(Order.asc(orderByArray[i]));
			if("desc".equals(orderArray[i])) criteria.addOrder(Order.desc(orderByArray[i]));
		}
		return true;
	}

}
