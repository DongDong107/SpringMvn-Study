package kr.co.rland.web.repository.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.co.rland.web.entity.Menu;
import kr.co.rland.web.repository.MenuRepository;

//@Repository
public class JdbcMenuReposiory implements MenuRepository {
	
	@Autowired
	private DataSource dataSource;
	
	@Override	
	public List<Menu> findAll() {
		
		String sql = String.format("select id, name, price, regDate, categoryId from menu");
		
//		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mariadb://db.newlecture.com:3306/rlanddb");
//        dataSourceBuilder.username("rland");
//        dataSourceBuilder.password("20220823");
//		
//        DataSource dataSource = dataSourceBuilder.build();
		
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		
		List<Menu> list = template.query(sql, new BeanPropertyRowMapper(Menu.class));
		
		
		
		return list;	
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

//String sql = String.format("select id, name, price, regDate, categoryId from menu");
//List<Menu> list = new ArrayList<>();
//
//try {
//	Class.forName("org.mariadb.jdbc.Driver");
//	String url = "jdbc:mariadb://db.newlecture.com:3306/rlanddb";
//	Connection con = DriverManager.getConnection(url, "rland", "20220823");
//	con.setAutoCommit(false);
//	
//	Statement st = con.createStatement();
//	ResultSet rs = st.executeQuery(sql);
//
//	// 필터링, 집계, 정렬
//	while (rs.next()) // 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
//	{
//		long id = rs.getLong("id");
//		String name = rs.getString("name");
//		Date regDate = rs.getDate("regDate");
//		int categoryId = rs.getInt("categoryId");
////		long regMemberId = rs.getLong("regMemberId");
//		
//		Menu menu = new Menu(id, name, 1000, regDate, categoryId, 1);
//		list.add(menu);
//	}
//	con.commit();
//	con.close();
//} catch (Exception e) {
////	con.rollback();
//	e.printStackTrace();
//}