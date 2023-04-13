package kr.co.rland.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RlandSecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	
	// 콩자루에 담아조 객체 만들어서 리턴할거야 설정하게되는 녀석
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//http로 오는 주소에 대한 필터링
		
		http
			.cors()
			.and()
			.csrf().disable()
			.authorizeHttpRequests()
				// 아래 url 빼고
				.requestMatchers("/admin/**").hasAnyRole("ADMIN")
				.requestMatchers("/member/**").hasAnyRole("ADMIN","MEMBER")
				// 나머지는 허가
				.anyRequest().permitAll()
			.and()
				.formLogin()
				// 이건 단순하게 페이지만
				.loginPage("/user/login")
				// 사용자가 원하는 url로
				.loginProcessingUrl("/user/login")
				.defaultSuccessUrl("/admin/index")
			.and()
				.logout()
				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/index");
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	// 사용자 데이터 서비스
	// 1. 인메모리 서비스
	//@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails newlec = User.builder()
							.username("newlec")
							.password(passwordEncoder().encode("111"))
							.roles("ADMIN","MEMBER")
							.build();
		
//		User user = new User("aa","bb",null);
		
		
		UserDetails dragon = User.builder()
				.username("dragon")
				.password("111")
				.roles("MEMBER")
				.build();

		
//		Member member = Member.builder().id(1L).userName("newlec").build();
		
		return new InMemoryUserDetailsManager(newlec, dragon);
	}
	
	// 2. JDBC 서비스
		//@Bean
		public UserDetailsService jdbcUserDetailsService() {
			
			JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
			manager.setUsersByUsernameQuery("select username, pwd password, 1 enabled from member where username=?"); //username, password, enabled
			manager.setAuthoritiesByUsernameQuery("select username, 'ROLE_ADMIN' authority from member where username=?");
			
			return manager;
		}

	// 3. 커스텀 유저 서비스
		//@Bean
		public UserDetailsService rlandUserDetailsService() {
			
			
			return new RlandUserDetailsService();
		}

		// 3. LDAP 서비스 (윈도우 서비스 액티브 디렉토리)
}

	
	