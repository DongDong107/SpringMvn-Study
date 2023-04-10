package kr.co.rland.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.rland.web.entity.Member;
import kr.co.rland.web.service.MemberService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String login(String uid, String pwd) {

//		Member member = memberService.getByUserName(uid);
		boolean isValid = memberService.isValidMember(uid,pwd);
		
		return "/user/login";
	}

}
