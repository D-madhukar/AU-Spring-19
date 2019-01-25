package com.accolite.hibernate5.pojo;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Employee extends Person {
	@Id
	@GeneratedValue
	int id;
	public Employee(int id, String officeName,String Name) {
		super(Name);
		this.id = id;
		this.officeName = officeName;
	}
	public Employee() {
		super();
	}
	

	@Override
	public String toString() {
		return "Employee [officeName=" + officeName + ", id=" + id + ", name=" + name + "]";
	}
	String officeName;
	
	
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
}
