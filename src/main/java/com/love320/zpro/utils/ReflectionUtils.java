package com.love320.zpro.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class ReflectionUtils {
	
	public static Class getSuperClassGenricType(final Class clazz) {
		Type genType = clazz.getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		return (Class) params[0];
	}
	
	public static boolean methodInvoke(String name,Object obj,Object refobj){
		 return methodInvoke(name,obj,refobj,refobj.getClass());
	}
	
	public static boolean methodInvoke(String name,Object obj,Object refobj,Class clazz){
		 
		try {
			//对象注入
			 Method method = obj.getClass().getMethod("set"+ name.substring(0,1).toUpperCase() +  name.substring(1),clazz);
			// 反射注入
            method.invoke(obj, refobj);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
}
