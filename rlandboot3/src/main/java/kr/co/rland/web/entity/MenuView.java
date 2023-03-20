package kr.co.rland.web.entity;

import java.util.Date;

public class MenuView extends Menu{

	
	private String categoryName;	
	
	public MenuView(String categoryName) {

	}
	
	public MenuView() {
		
	}

	public MenuView(long id, String name, Integer price, Date regDate, String img, Integer categoryId,
			long regMemberId, String categoryName) {
		super(id, name, price, regDate, img, categoryId, regMemberId);
		
		this.categoryName = categoryName;
	}

	public MenuView(String name, Integer price, String img, Integer categoryId, long regMemberId, String categoryName) {
		super(name, price, img, categoryId, regMemberId);
		
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "MenuView [categoryName=" + categoryName + "]";
	}

	
	
	
	
}
