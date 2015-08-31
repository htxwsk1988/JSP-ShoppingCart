package com.cc.cad.model;

// EJB representing each record in shop.Movies table.
public class MovieBean {
	
	private long Id; 
	private String Name;
	private String Description;
	private double Price; 
	private int InventoryNum; 
	private String Publisher; 
	private String Image;
	private String type; 
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getInventoryNum() {
		return InventoryNum;
	}
	public void setInventoryNum(int inventoryNum) {
		InventoryNum = inventoryNum;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
