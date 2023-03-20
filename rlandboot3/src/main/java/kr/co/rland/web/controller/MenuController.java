package kr.co.rland.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;

// 이걸 안써두면 스프링이 안읽음.
@Controller
// 반복되는 상위 주소들은 이렇게 맵핑 주소 적어서 축약시킬 수 있다.
@RequestMapping("/menu")

public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@GetMapping("list")
	public String list(Model model) {
		
		List<MenuView> list = service.getViewList();
		model.addAttribute("list", list);
		
		
		return "menu/list"; 
	}
	
	// http://localhost:8080/menu/detail?id=713	
	@GetMapping("detail")
	public String detail(int id, Model model) {
		
		Menu menu = service.getById(id);
		
		model.addAttribute("menu", menu);
		
		return "menu/detail";
	}
}
