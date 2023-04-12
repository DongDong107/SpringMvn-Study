package kr.co.rland.web.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

// 이름 설정을 admin 안붙여서 안해놓으면 일반위의 MenuController랑 이름이 겹치게 돼서 오류남.
@Controller("adminHomeController")
@RequestMapping("admin")
public class HomeController {
	
	@GetMapping("index")
	public String index(HttpSession session) {
		
//		request.getSession().setAttribute("test", "hehe");
		
//		if(session.getAttribute("username")==null) {
//			return "redirect:/user/login?returnURL=/admin/index";
//		}
		
		return "admin/index";
	}
	
	
}
