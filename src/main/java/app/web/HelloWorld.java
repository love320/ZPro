package app.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.love320.zpro.code.bean.Filter;

//测试
@Controller
public class HelloWorld{
	

	@RequestMapping("/index")
	public String homePage(HttpServletRequest request){
		List<Filter> filters = Filter.parse(request.getParameterMap());
		System.out.println(request.getParameterMap());
		System.out.println(filters.get(1).getNames().length);
		System.out.println(filters.get(1).getValue());
		return "login";
	}

}
