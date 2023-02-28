package kr.co.rland.web.repository.mybatis;

import java.util.ArrayList;
import java.util.List;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;

public class MbMenuRepository implements MenuRepository {

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Menu>();
	}

}
