package kr.co.rland.web.repository;


import java.util.List;

import kr.co.rland.web.entity.Menu;

public interface MenuRepository {
	List<Menu> findAll();
	
}	
