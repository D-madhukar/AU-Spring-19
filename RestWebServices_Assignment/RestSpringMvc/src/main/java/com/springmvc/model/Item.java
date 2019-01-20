package com.springmvc.model;
public class Item {
	int id;
	String name;
	int price;
	public Item() {
		
	}
	public Item(int id,String name,int price) {
		this.id=id;
		this.name=name;
		this.price=price;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public String toString() {
		return "id="+id+" name="+name+" price="+price;
	}
}

