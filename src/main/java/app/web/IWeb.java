package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.love320.zpro.code.bean.Page;

public interface IWeb<T> {

	@RequestMapping("/list")
	public abstract String list(Model model, Page<T> page,HttpServletRequest request);

	@RequestMapping("/add")
	public abstract String add(Model model);

	@RequestMapping("/edit/{id}")
	public abstract String edit(Model model,@PathVariable Long id);

	@RequestMapping("/save")
	public abstract ModelAndView save(T entity);

	@RequestMapping("/delete/{id}")
	public abstract ModelAndView delete(@PathVariable Long id);

}