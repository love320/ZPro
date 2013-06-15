package com.love320.zpro.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.love320.zpro.bean.Page;

public interface IWeb<T> {

	@RequestMapping("/list")
	public abstract String list(Model model, Page<T> page,
			HttpServletRequest request);

	@RequestMapping("/input")
	public abstract String input(Model model,
			@RequestParam(required = false) Long id);

	@RequestMapping("/save")
	public abstract ModelAndView save(T entity);
	
	@RequestMapping("/delete")
	public abstract ModelAndView delete(Long id);

}