package kr.co.rland.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.rland.web.entity.Category;
import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.entity.RcmdMenuView;
import kr.co.rland.web.service.CategoryService;
import kr.co.rland.web.service.MenuService;
import kr.co.rland.web.service.RcmdMenuService;

// 이걸 안써두면 스프링이 안읽음.
@Controller
// 반복되는 상위 주소들은 이렇게 맵핑 주소 적어서 축약시킬 수 있다.
@RequestMapping("/menu")

public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RcmdMenuService rcmdMenuService;
	
	@GetMapping("list")
	public String list(
			// @requestparam ??????			
			@RequestParam(name = "p", defaultValue="1", required = false)int page,
			@RequestParam(name = "c", required = false) Integer categoryId,
			@RequestParam(name = "q", required = false) String query,
			Model model) {		
		
		List<MenuView> list = service.getViewList(page, categoryId, query);
		List<Category> catogoryList = categoryService.getList();
				
		model.addAttribute("list", list);
		model.addAttribute("categoryList", catogoryList);		
		
		return "menu/list2"; 
	}
	
	// http://localhost:8080/menu/detail?id=713	
	@GetMapping("detail")
	public String detail(int id, Model model, HttpServletRequest request) {
		//model == request 저장소!! 우선 순위는 model 더 높다.
		request.setAttribute("name", "전재준");
		model.addAttribute("name", "김선호");
		Menu menu = service.getById(id);
		List<RcmdMenuView> rcmdMenuList = rcmdMenuService.getViewListByMenuId(id);
		
		String categoryName = categoryService.getNameById(menu.getCategoryId());
		int cartCount = 10;
		
		model.addAttribute("menu", menu);
		model.addAttribute("rcmdMenuList",rcmdMenuList);
		model.addAttribute("categoryName",categoryName);
		
		//포워딩
		return "menu/detail2";
	}
}
