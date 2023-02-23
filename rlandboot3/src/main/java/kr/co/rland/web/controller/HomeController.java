package kr.co.rland.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index() {
		return "/WEB-INF/view/admin/menu/reg.jsp";
	}	
	
	
	
}
