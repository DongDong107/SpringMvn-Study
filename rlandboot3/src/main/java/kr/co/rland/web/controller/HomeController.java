package kr.co.rland.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile img) {
		
		System.out.println(img);
		
		return "ok";
	}
	
	@RequestMapping("index")
	public String index(Model model, HttpServletResponse response) throws UnsupportedEncodingException {
		
		String data = URLEncoder.encode("cookie래요~","utf-8");
		
		System.out.println(data);
		
		Cookie cookie = new Cookie("my", data);
		response.addCookie(cookie);
		
		model.addAttribute("data", data);
		
		return "/WEB-INF/view/index.jsp";		
	}	
	
	
	
}
