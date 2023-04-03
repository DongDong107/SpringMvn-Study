package kr.co.rland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;
import kr.co.rland.web.repository.MenuRepository;

@Service
public class DefaultMenuService implements MenuService {
	
	@Autowired
	private MenuRepository repository;	
	
	public void setRepository(MenuRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<Menu> getList() {
		
		return repository.findAll(0,10,"",1,null,"regDate","desc");
	}

	@Transactional
	@Override
	public void pointUp() {
		Menu menu = new Menu();
		menu.setId(771L);
		menu.setPrice(20000);
		repository.update(menu);
		
		menu.setId(771L);
		menu.setPrice(40000);
		repository.update(menu);		
	}
	
	@Override
	public Menu getById(long id) {		
		Menu menu = repository.findById(id);		
		return menu;
	}

	@Override
	public List<Menu> getList(int page) {
		return null;
	}

	@Override
	public List<Menu> getList(int page, String query) {
		return null;
	}

	@Override
	public List<Menu> getList(int page, int category) {
		return null;
	}

	@Override
	public List<Menu> getList(int page, int categoryId, String query) {
		return null;
	}

	@Override
	public List<MenuView> getViewList() {
		int page = 1;
		int size = 10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, null, null, null);
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page) {
		int size = 10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, null, null, null);
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, String query) {
		int size = 10;
		List<MenuView> list = repository.findViewAll(page, size, query, null, null, null, null);
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, Integer categoryId) {
		int size = 10;
		List<MenuView> list = repository.findViewAll(page, size, null, null, categoryId, null, null);
		return list;
	}

	@Override
	public List<MenuView> getViewList(int page, Integer categoryId, String query) {
		int size = 9;
		int offset = (page-1)*size;
		String orderField = "reg_date";
		String order = "desc";
		List<MenuView> list = repository.findViewAll(offset, size, query, categoryId, null, orderField, order);
		return list;
	}


	@Override
	public void add(Menu menu) {
		repository.insert(menu);
		
	}


	

}

