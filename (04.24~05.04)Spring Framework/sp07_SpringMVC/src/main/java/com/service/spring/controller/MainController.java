package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController{  //POJO(Plain Old Java Object == 어느 것에도 제약받지 않는(==상속받지 않는다. implements x) 아주 단순한 자바 클래스)기반으로 만든다.
	//implements가 아니라 annotation으로 한다
	@RequestMapping("/main.do")
	public ModelAndView main() {
		return new ModelAndView("main_view", "info", "MainController Annotation~~!!");
		
	}
}
