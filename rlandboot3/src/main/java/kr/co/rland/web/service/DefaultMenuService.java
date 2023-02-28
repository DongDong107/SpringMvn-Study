package kr.co.rland.web.service;

import java.util.List;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;

public class DefaultMenuService implements MenuService {
	
	private MenuRepository repository;	
	
	public void setRepository(MenuRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<Menu> getList() {
		// TODO Auto-generated method stub
		
		return repository.findAll();
	}

}
