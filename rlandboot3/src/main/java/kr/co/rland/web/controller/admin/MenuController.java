package kr.co.rland.web.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller("adminMenuController")
@RequestMapping("/admin/menu")

public class MenuController {
	@GetMapping("list")
	public String list() {
		return "/WEB-INF/view/admin/menu/list.jsp";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "admin menu detail";
	}
	
	// .admin/menu/
	// /admin/leg/html
	
	// 등록품을 주세요
//	@RequestMapping("reg") //->service():Get/post를 내가 다 처리하는 매핑
	@GetMapping("reg")
	public String reg() {
		return "/WEB-INF/view/admin/menu/reg.jsp";
	}
	
	// 폼입력해서 제출이요
//	@RequestMapping("reg")
	@PostMapping("reg")
	public String reg(String title) {
		// 등록하고
		System.out.println("메뉴 등록 완료");
		return "redirect:list";
	}
}
