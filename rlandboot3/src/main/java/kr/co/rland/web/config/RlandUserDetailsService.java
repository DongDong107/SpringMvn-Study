package kr.co.rland.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.rland.web.entity.Member;
import kr.co.rland.web.repository.MemberRepository;

@Service
public class RlandUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		// RlandUserDetails에 담을 데이터 준비
		Member member = repository.findByUserName(username);
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		// 데이터 준비되면 RlandUserDetails 그릇 객체를 만들어서 반환해주면 끝!
		RlandUserDetails user = new RlandUserDetails();
		user.setId(member.getId());
		user.setUsername(member.getUserName());
		user.setPassword(member.getPwd());
		user.setEmail(member.getEmail());
		user.setAuthorities(authorities);
				
		return user;
	}

}
