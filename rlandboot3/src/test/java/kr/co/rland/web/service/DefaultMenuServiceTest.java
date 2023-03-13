package kr.co.rland.web.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMybatis
class DefaultMenuServiceTest {

	@Autowired
	private MenuService service;
	
	@Test
	void test() {
		service.pointUp();
		System.out.println("작업완료");
	}

}
