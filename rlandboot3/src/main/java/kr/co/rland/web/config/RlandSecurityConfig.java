package kr.co.rland.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RlandSecurityConfig {
	
	// 콩자루에 담아조 객체 만들어서 리턴할거야 설정하게되는 녀석
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//http로 오는 주소에 대한 필터링
		
		http
			.authorizeHttpRequests()
			.requestMatchers("/admin/**").hasAnyRole("ADMIN")
			.requestMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")
			.anyRequest().permitAll();
			
		
		return http.build();
	}
}
