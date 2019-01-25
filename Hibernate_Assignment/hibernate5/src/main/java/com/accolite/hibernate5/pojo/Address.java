package com.accolite.hibernate5.pojo;

import javax.persistence.Embeddable;
import javax.persistence.Id;
@Embeddable
public class Address {
//	@Id 
//	int id;
	String street;
	String city;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
