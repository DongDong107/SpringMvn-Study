package kr.co.rland.web.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.rland.web.entity.Menu;

@Mapper
public interface MenuRepository {
	
	List<Menu> findAll();	
	Menu findById(long id);
	Menu insert(Menu menu);
	Menu update(Menu menu);
	void delete(long id);
}	
