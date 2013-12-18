package app.web;


import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.love320.zpro.code.bean.Page;
import com.love320.zpro.code.utils.ConvertUtils;

import app.entity.Authority;
import app.entity.Role;
import app.entity.User;
import app.services.RoleService;
import app.services.SaeUpFileService;
import app.services.UserService;
import app.utils.WebUtils;

@Controller
@RequestMapping("/user")
public class UserWeb implements IWeb<User> {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	private static Logger logger = Logger.getLogger(UserWeb.class.getName());

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
			logger.info( "Ok login "+token.toString());
			return new ModelAndView("redirect:/user/list"); 
		} catch (Exception e) {
			logger.info("Error login "+e.getMessage());
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
		Map  parameters = WebUtils.build(request);
		page = userService.find(page,parameters);
		model.addAttribute("page",page);
		return "user/list";
	}
	
	
	@Override
	@RequestMapping("/add")
	public String add(Model model) {
		return edit(model,null);
	}

	/* (non-Javadoc)
	 * @see app.controllers.IWeb#input(org.springframework.ui.Model, java.lang.Long)
	 */
	@Override
	@RequestMapping("/edit/{id}")
	public String edit(Model model,@PathVariable Long id){
		User entity = new User();
		if(id != null && id > 0) entity = userService.get(id);
		model.addAttribute("entity", entity);
		model.addAttribute("rolelist",entity.getRoleList());
		model.addAttribute("allrolelist",roleService.findAll());
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

		return new ModelAndView("redirect:/user/list"); 
	}
	
	@RequestMapping("/saveids")
	public ModelAndView saveids(User entity,@RequestParam(required=false)Long[] ids) {
		ConvertUtils.listByIds("roleList", entity, ids, Role.class);
		userService.saveOrUdate(entity);
		return new ModelAndView("redirect:/user/list");
	}
	
	/* (non-Javadoc)
	 * @see app.controllers.IWeb#delete(java.lang.Long)
	 */
	@Override
	@RequestMapping({"/delete","/delete/{id}"})
	public ModelAndView delete(@PathVariable Long id){
		boolean st = userService.delete(id);
		return new ModelAndView("redirect:/user/list"); 
	}
	
}
