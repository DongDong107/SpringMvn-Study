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

	@Override
	public Menu findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu insert(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu update(Menu menu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
