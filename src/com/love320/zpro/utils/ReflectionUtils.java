package com.love320.zpro.utils;

import java.lang.reflect.Type;
import java.lang.reflect.ParameterizedType;

public class ReflectionUtils {
	public static Class getSuperClassGenricType(final Class clazz) {
		Type genType = clazz.getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		return (Class) params[0];
	}
}
