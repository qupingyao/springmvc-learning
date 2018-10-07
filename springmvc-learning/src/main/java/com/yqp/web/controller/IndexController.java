package com.yqp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.yqp.web.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public ModelAndView index(String word) {
		String str = userService.say(word);
		ModelAndView view = new ModelAndView("index");
		view.addObject("str", str);
		return view;
	}

}