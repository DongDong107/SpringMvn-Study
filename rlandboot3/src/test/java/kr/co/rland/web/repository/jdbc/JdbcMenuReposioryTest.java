package kr.co.rland.web.repository.jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;

class JdbcMenuReposioryTest {

	@Test
	void testFindAll() {
		MenuRepository repository = new JdbcMenuReposiory();
		List<Menu> list = repository.findAll();
		
		System.out.println(list.size());
		System.out.println();
	}

}
