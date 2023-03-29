package kr.co.rland.web.controller.admin;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.service.MenuService;

// 이름 설정을 admin 안붙여서 안해놓으면 일반위의 MenuController랑 이름이 겹치게 돼서 오류남.
@Controller("adminHomeController")
@RequestMapping("admin")
public class HomeController {
	
	@GetMapping("index")
	public String index() {
		return "admin/index";
	}
	
	
}
