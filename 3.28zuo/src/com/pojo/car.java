package com.pojo;

public class car {
	 private int id;
	  private String name;
	  private String color;
	  private String img;
	  private double price;
	  private double price1;
	  
	public car(String name, String color, double price, double price1) {
		super();
		this.name = name;
		this.color = color;
		this.price = price;
		this.price1 = price1;
	}
	public double getPrice1() {
		return price1;
	}
	public void setPrice1(double price1) {
		this.price1 = price1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public car(String name, String color, String img, double price) {
		super();
		this.name = name;
		this.color = color;
		this.img = img;
		this.price = price;
	}
	public car() {
		super();
		// TODO Auto-generated constructor stub
	}
}
