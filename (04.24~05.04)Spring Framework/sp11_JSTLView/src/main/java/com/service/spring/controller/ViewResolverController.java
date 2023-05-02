package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//pojo기반이라는 건 implements 할 필요가 없다는 말
@Controller
public class ViewResolverController {
	
	@RequestMapping("findBoard.do")
	public String findBoard() {
		System.out.println("findBoard.do 요청 처리함...");
		return "board_result";
	}
	@RequestMapping("findProduct.do")
	public String findProduct() {
		System.out.println("findProduct.do 요청 처리함...");
		return "product_result";
	}
	@RequestMapping("register.do")
	public String register(Model model) {
		System.out.println("register.do 요청 처리함...");
		model.addAttribute("info", "InternalResourceViewResolver"); //info라는 이름으로 바인딩함
		return "register_result";
	}

}
