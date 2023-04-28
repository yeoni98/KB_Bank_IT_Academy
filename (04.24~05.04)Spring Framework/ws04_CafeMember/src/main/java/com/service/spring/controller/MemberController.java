package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.service.spring.domain.MemberVO;
import com.service.spring.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/register.do")
	public ModelAndView insert(MemberVO vo) throws Exception{
		
		memberService.registerMember(vo);
		String path = "index.jsp";
		return new ModelAndView(path, true);
//		return new ModelAndView("insert_result","vo",vo);
		
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(String id) throws Exception{
		
		memberService.registerMember(id);
		String path = "index.jsp";
		return new ModelAndView(path, true);
//		return new ModelAndView("insert_result","vo",vo);
		
	}
	
	
	@RequestMapping("/update.do")
	memberService.updateMember(vo);
	String path = "index.jsp";
	return new ModelAndView(path, true);
//	return new ModelAndView("insert_result","vo",vo);
	
}
	
	@RequestMapping("/myProductSearch.do")
	public ModelAndView find(String command, String word) throws Exception{
		List<MyProduct> list = null;
		String viewName = "";
		if(command.equals("findProductByName")) {
			list=myProductService.findProductByName(word);
			viewName = "find_result";
		}else if(command.equals("findProductByMaker")) {
			list=myProductService.findProductByMaker(word);
			viewName = "find_result";
		}else if(command.equals("findProducts")) {
			list=myProductService.findProducts();
			viewName = "find_result";
		}
		return new ModelAndView(viewName,"list",list);
		
	}

}









