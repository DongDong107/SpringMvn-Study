package kr.co.rland.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.co.rland.web.service.MemberService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("login")
	public String login(String uid, 
						String pwd, 
						String returnURL, 
						HttpSession session) {

//		Member member = memberService.getByUserName(uid);
		boolean isValid = memberService.isValidMember(uid,pwd);
		System.out.println(isValid);
		
		if(isValid) {
			// 현재 로그인한 유저의 id 까지 얻을 수 있는 일석이조.
			session.setAttribute("username", uid);
			
			if(returnURL != null)
				return "redirect:"+returnURL;
			
			return "redirect:/index";
		}
		
		return "redirect:login?error";
	}
	
	

}
