package kr.co.rland.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.rland.web.entity.Menu;
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

}

