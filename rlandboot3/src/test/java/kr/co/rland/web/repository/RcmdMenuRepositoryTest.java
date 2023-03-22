package kr.co.rland.web.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import kr.co.rland.web.entity.RcmdMenuView;

@AutoConfigureTestDatabase(replace = Replace.NONE)
@MybatisTest
class RcmdMenuRepositoryTest {
	
	@Autowired
	private RcmdMenuRepository repository;
	
	@Test
	void test() {
		List<RcmdMenuView> list = repository.findViewAllByMenuId(617);
		for(RcmdMenuView e : list) {
			System.out.println(e);
		}
		
	}

}
