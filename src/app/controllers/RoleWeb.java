package app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.love320.zpro.bean.Page;
import com.love320.zpro.utils.WebUtils;
import com.love320.zpro.web.IWeb;

import app.entity.Role;
import app.services.RoleService;

@Controller
@RequestMapping("/role")
public class RoleWeb implements IWeb<Role> {
	
	@Autowired
	private RoleService roleService;

	@Override
	@RequestMapping("/list")
	public String list(Model model, Page<Role> page, HttpServletRequest request) {
		//列表
		page = roleService.find(page, WebUtils.build(request));
		model.addAttribute("page", page);
		return "role/list";
	}

	@Override
	@RequestMapping("/input")
	public String input(Model model, Long id) {
		if(id != null) model.addAttribute("entity", roleService.get(id));
		return "role/input";
	}

	@Override
	@RequestMapping("/save")
	public ModelAndView save(Role entity) {
		roleService.saveOrUdate(entity);
		return new ModelAndView("redirect:/role/list.do"); 
	}

	@Override
	@RequestMapping("/delete")
	public ModelAndView delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
