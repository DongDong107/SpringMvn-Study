package kr.co.rland.web.repository.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;

@Repository
public class MbMenuRepository implements MenuRepository {
	
	// mybatis 콩자루에서 꺼내와 주는 친구	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Menu> findAll() {
		MenuRepository repository = session.getMapper(MenuRepository.class);
		return repository.findAll(0,10,null,null,null,null,null);		
	}
	
	@Override
	public List<Menu> findAll(Integer offset, Integer size, String query, Integer categoryId, Integer price,
			String orderField, String orderDisr) {
		// TODO Auto-generated method stub
		MenuRepository repository = session.getMapper(MenuRepository.class);
		return repository.findAll(offset,size,query,categoryId,price,orderField,orderDisr);
	}
	
	@Override
	public List<Menu> findAll(Integer offset, Integer size){
		MenuRepository repository = session.getMapper(MenuRepository.class);
		return repository.findAll(offset,size,null,null,null,null,null);
	}
	
	@Override
	public List<Menu> findAllByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		MenuRepository repository = session.getMapper(MenuRepository.class);
		return repository.findAllByIds(ids);
	}
	
	@Override
	public void update(Menu menu) {
		// TODO Auto-generated method stub
		
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
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public List<Menu> findAll() {
//		// TODO Auto-generated method stub
//		MenuRepository menuDao = session.getMapper(MenuRepository.class);
//		
//		return menuDao.findAll();
//	}
	
//	@Override
//	public List<Menu> findAll(int page) {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	@Override
//	public Menu update(Menu menu) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
