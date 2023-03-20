package kr.co.rland.web.entity;

import java.util.Date;

public class Menu {
	private long id;
	private String name;
	private Integer price;
	@Column("reg_date")
	private Date regDate;
	private String img;
	private Integer categoryId;
	private long regMemberId;
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Menu() {
		
	}	

	public Menu(long id, String name, Integer price, Date regDate, String img, Integer categoryId, long regMemberId) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.regDate = regDate;
		this.img = img;
		this.categoryId = categoryId;
		this.regMemberId = regMemberId;
	}
		

	public Menu(String name, Integer price, String img, Integer categoryId, long regMemberId) {
		
		this.name = name;
		this.price = price;
		this.img = img;
		this.categoryId = categoryId;
		this.regMemberId = regMemberId;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public long getRegMemberId() {
		return regMemberId;
	}


	public void setRegMemberId(long regMemberId) {
		this.regMemberId = regMemberId;
	}


	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price + ", regDate=" + regDate + ", img=" + img
				+ ", categoryId=" + categoryId + ", regMemberId=" + regMemberId + "]";
	}
	
	
	
	
	
}
