package app.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.love320.zpro.bean.Filter;
import com.love320.zpro.bean.Page;

import app.services.UserService;

@Controller
@RequestMapping("/user")
public class User {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(Model mode,@RequestParam(required=false)String name,@RequestParam(required=false)String pwd){
		//非登录，载入登录页面
		if(name == null || pwd == null || name.length() < 5) return "login";
		
		//登录验证
		System.out.println(userService);
		return "login";
	}
	
	@RequestMapping("/list")
	public String list(Model model,HttpServletRequest request){
		Page page = new Page<User>();
		List<Filter> filters = Filter.parse(request.getParameterMap());
		page = userService.findPage(page,filters);
		model.addAttribute("list",page.getList());
		return "user/list";
	}
	
}
