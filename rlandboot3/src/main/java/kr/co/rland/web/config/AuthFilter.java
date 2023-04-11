package kr.co.rland.web.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

//@Component
public class AuthFilter implements Filter {
	
	private static final String[] authUrls= {
			"/admin/**","/member/**"
	};
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		System.out.println(uri);
		
		
		System.out.println("입구 실행");
		chain.doFilter(request, response);
		System.out.println("출구 위이잉");
		
	}

}
