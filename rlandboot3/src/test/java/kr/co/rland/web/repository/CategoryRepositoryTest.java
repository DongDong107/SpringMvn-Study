package kr.co.rland.web.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import kr.co.rland.web.entity.Category;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;	
	
	@Test
	void testFindAll() {
		List<Category> list = repository.findAll();
		
		for(Category e : list)
			System.out.println(e);
	}

}
