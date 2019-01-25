package com.accolite.hibernate5.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="ge5",query="FROM Worker where id>?1")
})

public class Worker extends Person {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	int id;
	
	int dailWage;
	public int getDailWage() {
		return dailWage;
	}

	public void setDailWage(int dailWage) {
		this.dailWage = dailWage;
	}

	@Override
	public String toString() {
		return "Worker [dailWage=" + dailWage + ", id=" + id + ", name=" + name + "]";
	} 
}
