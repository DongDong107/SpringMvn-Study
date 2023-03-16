package kr.co.rland.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 이걸 안써두면 스프링이 안읽음.
@Controller
// 반복되는 상위 주소들은 이렇게 맵핑 주소 적어서 축약시킬 수 있다.
@RequestMapping("/menu")

public class MenuController {
	@GetMapping("list")
	public String list() {
		return "menulist"; // 타일즈에게 조립해달라는 조합에 대한 이름을 반환
//		return "/WEB-INF/view/inc/layout.jsp";
////		return "/WEB-INF/view/menu/list.jsp";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "menu detail 바뀜";
	}
}
