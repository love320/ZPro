package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.love320.zpro.code.bean.Page;
import com.love320.zpro.code.utils.ConvertUtils;
import app.entity.Authority;
import app.entity.Role;
import app.services.AuthorityService;
import app.services.RoleService;
import app.utils.WebUtils;

@Controller
@RequestMapping("/role")
public class RoleWeb implements IWeb<Role> {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthorityService authorityService;

	@Override
	@RequestMapping("/list")
	public String list(Model model, Page<Role> page, HttpServletRequest request) {
		//列表
		page = roleService.find(page, WebUtils.build(request));
		model.addAttribute("page", page);
		return "role/list";
	}

	@Override
	@RequestMapping("/add")
	public String add(Model model) {
		return edit(model,null);
	}

	@Override
	@RequestMapping("/edit/{id}")
	public String edit(Model model,@PathVariable Long id) {
		Role entity = new Role();
		if(id != null) entity = roleService.get(id);
		model.addAttribute("entity", entity);
		model.addAttribute("authoritylist", entity.getAuthorityList());
		model.addAttribute("allauthoritylist", authorityService.list());
		return "role/input";
	}

	@Override
	@RequestMapping("/save")
	public ModelAndView save(Role entity) {
		roleService.saveOrUdate(entity);
		return new ModelAndView("redirect:/role/list"); 
	}
	
	@RequestMapping("/saveids")
	public ModelAndView saveids(Role entity,Long[] ids) {
		ConvertUtils.listByIds("authorityList", entity, ids, Authority.class);
		roleService.saveOrUdate(entity);
		return new ModelAndView("redirect:/role/list"); 
	}

	@Override
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		boolean st = roleService.delete(id);
		return new ModelAndView("redirect:/role/list"); 
	}

}
