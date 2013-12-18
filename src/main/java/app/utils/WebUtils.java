package app.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.love320.zpro.code.utils.MapUtils;

public class WebUtils {

	public static Map build(HttpServletRequest request){
		return MapUtils.copy(request.getParameterMap());
	}
	
	public static Map buildAuto(HttpServletRequest request){													
		String method = request.getMethod();											
		if(method.toUpperCase().equals("GET")){											
			return MapUtils.copy(request.getParameterMap(),"UTF-8");										
		}else{											
			return MapUtils.copy(request.getParameterMap());										
		}											
	}	
	
}
