package kr.co.rland.web.controller.admin;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.rland.web.repository.MenuRepository;
import kr.co.rland.web.repository.jdbc.JdbcMenuReposiory;
import kr.co.rland.web.service.MenuService;

// 이름 설정을 admin 안붙여서 안해놓으면 일반위의 MenuController랑 이름이 겹치게 돼서 오류남.
@Controller("adminMenuController")
@RequestMapping("/admin/menu")
public class MenuController {
	
	@Autowired
	private MenuService service;
	
//	public MenuController() {
//		
//	}
//		
//	public MenuRepository getMenuRepository() {
//		return menuRepository;
//	}
//	
//	
//	public void setMenuRepository(MenuRepository menuRepository) {
//		this.menuRepository = menuRepository;
//	}
//	
//	public MenuController(MenuRepository menuRepository) {
//		super();
//		this.menuRepository = menuRepository;
//	}


	@GetMapping("list")
	public String list(
			@RequestParam(name="p", defaultValue = "1") int page,
			@RequestParam(name="q", required = false) String query,
			@CookieValue("my") String myCookie, 
			@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language 
//			HttpServletRequest request
			) throws UnsupportedEncodingException {
		
//		String myCookie ="";
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equals("my")) {
//				myCookie = cookie.getValue();
//				break;
//			}
//		}
		
		System.out.printf("Accept-Language : %s\n",language);
		myCookie = URLDecoder.decode(myCookie, "utf-8");
		System.out.println(myCookie);
		
		System.out.println(page);
		System.out.println(query);
		for(int i=0; i<service.getList().size() ; i++) {
			System.out.println(service.getList().get(i));	
		}
		System.out.println(service.getList());
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
