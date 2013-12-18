package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.entity.Authority;
import app.services.AuthorityService;
import app.utils.WebUtils;

import com.love320.zpro.code.bean.Page;

@Controller
@RequestMapping("/authority")
public class AuthorityWeb implements IWeb<Authority> {
	
	@Autowired
	private AuthorityService authorityService;

	@Override
	@RequestMapping("/list")
	public String list(Model model, Page<Authority> page, HttpServletRequest request) {
		page = authorityService.find(page, WebUtils.build(request));
		model.addAttribute("page", page);
		return "authority/list";
	}
	
	@Override
	@RequestMapping("/add")
	public String add(Model model) {
		return edit(model,null);
	}

	@Override
	@RequestMapping("/edit/{id}")
	public String edit(Model model,@PathVariable Long id) {
		if(id != null) model.addAttribute("entity", authorityService.get(id));
		return "authority/input";
	}

	@Override
	@RequestMapping("/save")
	public ModelAndView save(Authority entity) {
		authorityService.saveOrUdate(entity);
		return new ModelAndView("redirect:/authority/list"); 
	}

	@Override
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id) {
		boolean st = authorityService.delete(id);
		return new ModelAndView("redirect:/authority/list"); 
	}

}
