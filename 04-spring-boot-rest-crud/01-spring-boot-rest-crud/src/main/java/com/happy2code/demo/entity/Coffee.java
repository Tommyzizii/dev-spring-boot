package com.happy2code.demo.entity;

public class Coffee {
	
	private String name;
	private String brand;
	private String sugarLevel;
	
	public Coffee() {
		
	}
	
	public Coffee(String name, String brand, String sugarLevel) {
		super();
		this.name = name;
		this.brand = brand;
		this.sugarLevel = sugarLevel;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSugarLevel() {
		return sugarLevel;
	}
	public void setSugarLevel(String sugarLevel) {
		this.sugarLevel = sugarLevel;
	}
	
	

}
