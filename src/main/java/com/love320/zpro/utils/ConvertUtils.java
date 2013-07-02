package com.love320.zpro.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConvertUtils {
	
	//给对象注入关联信息 
	public static void listByIds(String name,final Object srcObjects,final Long[] ids, final Class clazz){
		if(ids == null ) return;
		
		List objList = new ArrayList();
		
		 //ID集合目前剩余的id均不在源集合中,创建对象,为id属性赋值并添加到源集合中.
        for (Long id : ids) {
        	try {
    			Object newObjtc = clazz.newInstance();
    			ReflectionUtils.methodInvoke("id", newObjtc, id);
    			objList.add(newObjtc);
    		} catch (InstantiationException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IllegalAccessException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		
        ReflectionUtils.methodInvoke(name, srcObjects, objList,List.class);
		
	}

}
