package kr.co.rland.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.rland.web.entity.Menu;

@AutoConfigureTestDatabase(replace = Replace.NONE)
//@MybatisTest
@AutoConfigureMybatis
@SpringBootTest
class MenuRepositoryTest {
	
	@Autowired
	private MenuRepository repository;
	
	@Test
	void testFindAll() {
//		List<Menu> list = repository.findAll(
//				0, 10, null, null, null, "regDate", "desc");
		List<Menu> list = repository.findAll();
		for(Menu e : list) {
			System.out.println(e);
		}
//		System.out.println(list);
	}
	
//	@Test
	void testFindAllByIds() {
		List<Long> ids = new ArrayList<>();
		ids.add(616L);
		ids.add(617L);
		ids.add(713L);
		ids.add(737L);
		
		List<Menu> list = repository.findAllByIds(ids);
		System.out.println(list);
	}

	//@Test
	void testUpdate() {
		Menu menu = new Menu();
		menu.setId(856);
		menu.setName("아미아마리카노");
		
		// update가 반환해주는 값은 정수형. Menu 타입으로 넣으려고 해서 오류가 난 것.
		// 해결은 Dao 파일에서 update 메소드 반환 자료형 void 또는 int로 바꿔주기		
		repository.update(menu);
		
//		Menu m = repository.update(menu);
//		System.out.println(m);
	}

}
