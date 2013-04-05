package app.controllers;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.love320.zpro.bean.Page;
import com.love320.zpro.utils.WebUtils;
import com.love320.zpro.web.IWeb;

import app.entity.User;
import app.services.UserService;

@Controller
@RequestMapping("/user")
public class UserWeb implements IWeb<User> {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public ModelAndView login(Model mode,@RequestParam(required=false)String name,@RequestParam(required=false)String pwd){
		//非登录，载入登录页面
		if(name == null || pwd == null || name.length() < 5) new ModelAndView("login"); 
		
		//1. 接受提交的当事人和证书：
		UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
		token.setRememberMe(true);
		//2. 获取当前Subject：
		Subject currentUser = SecurityUtils.getSubject();
		//3. 登录： 
		try {
			currentUser.login(token);
			System.out.println( "Ok login "+token.toString());
			return new ModelAndView("redirect:/user/list.do"); 
		} catch (Exception e) {
			System.out.println("Error login "+e.getMessage());
		}
		
		return new ModelAndView("login"); 
	}
	
	//登出
	@RequestMapping("/logout")
	public ModelAndView logout(){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		return new ModelAndView("login"); 
	}
	
	/* (non-Javadoc)
	 * @see app.controllers.IWeb#list(org.springframework.ui.Model, com.love320.zpro.bean.Page, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	@RequestMapping("/list")
	public String list(Model model,Page<User> page ,HttpServletRequest request){
		System.out.println("Error list ");
		Map  parameters = WebUtils.build(request);
		page = userService.find(page,parameters);
		model.addAttribute("page",page);
		return "user/list";
	}
	
	/* (non-Javadoc)
	 * @see app.controllers.IWeb#input(org.springframework.ui.Model, java.lang.Long)
	 */
	@Override
	@RequestMapping("/input")
	public String input(Model model,@RequestParam(required=false)Long id){
		User entity = new User();
		if(id != null ){
			 entity = userService.get(id);
		}
		model.addAttribute("entity", entity);
		return "user/input";
	}
	
	/* (non-Javadoc)
	 * @see app.controllers.IWeb#save(app.entity.User)
	 */
	@Override
	@RequestMapping("/save")
	public ModelAndView save(User entity){
		if(entity.getId() == null){
			boolean st = userService.save(entity);//新增
		}else{
			boolean st = userService.update(entity);//更新
		}

		return new ModelAndView("redirect:/user/list.do"); 
	}
	
	/* (non-Javadoc)
	 * @see app.controllers.IWeb#delete(java.lang.Long)
	 */
	@Override
	@RequestMapping("/delete")
	public ModelAndView delete(Long id){
		boolean st = userService.delete(id);
		return new ModelAndView("redirect:/user/list.do"); 
	}
	
}
