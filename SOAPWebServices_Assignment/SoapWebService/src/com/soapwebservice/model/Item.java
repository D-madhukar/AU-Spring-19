/**
 * 
 */
package com.soapwebservice.model;

/**
 * @author Madhukar
 *
 */
public class Item {
	int id;
	String name;
	int price;
	public Item(int id,String name,int price) {
		this.id=id;
		this.name=name;
		this.price=price;
	}
	void setId(int id) {
		this.id=id;
	}
	void setName(String name) {
		this.name=name;
	}
	void setPrice(int price) {
		this.price=price;
	}
	int getId() {
		return this.id;
	}
	String getName() {
		return this.name;
	}
	int getPrice() {
		return this.price;
	}
	public String toString() {
		return "id="+id+" name="+name+" price="+price;
	}
}
