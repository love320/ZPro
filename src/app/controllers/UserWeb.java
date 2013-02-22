package app.controllers;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.love320.zpro.bean.Page;

import app.entity.User;
import app.services.UserService;

@Controller
@RequestMapping("/user")
public class UserWeb {
	
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
	public String list(Model model,Page<User> page ,HttpServletRequest request){
		page = userService.find(page,request.getParameterMap());
		model.addAttribute("page",page);
		return "user/list";
	}
	
	@RequestMapping("/input")
	public String input(Model model,@RequestParam(required=false)Long id){
		User entity = new User();
		if(id != null ){
			 entity = userService.get(id);
		}
		model.addAttribute("entity", entity);
		return "user/input";
	}
	
	@RequestMapping("/save")
	public ModelAndView save(User entity){
		if(entity.getId() == null){
			boolean st = userService.save(entity);//新增
		}else{
			boolean st = userService.update(entity);//更新
		}

		return new ModelAndView("redirect:/user/list.do"); 
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(Long id){
		boolean st = userService.delete(id);
		return new ModelAndView("redirect:/user/list.do"); 
	}
	
}
