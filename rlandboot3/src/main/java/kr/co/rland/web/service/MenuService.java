package kr.co.rland.web.service;

import java.util.List;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.entity.MenuView;

public interface MenuService {
		
	Menu getById(long id);
	
	void pointUp();
	
	void add(Menu menu);
	
	List<Menu> getList();
	List<Menu> getList(int page);
	List<Menu> getList(int page, String query);
	List<Menu> getList(int page, int category);
	List<Menu> getList(int page, int categoryId, String query);


	List<MenuView> getViewList();
	List<MenuView> getViewList(int page);
	List<MenuView> getViewList(int page, String query);
	List<MenuView> getViewList(int page, Integer categoryId);
	List<MenuView> getViewList(int page, Integer categoryId, String query);
	
	
}
