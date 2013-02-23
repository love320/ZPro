package com.love320.zpro.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebUtils {

	public static Map build(HttpServletRequest request){
		return MapUtils.copy(request.getParameterMap());
	}
	
}
