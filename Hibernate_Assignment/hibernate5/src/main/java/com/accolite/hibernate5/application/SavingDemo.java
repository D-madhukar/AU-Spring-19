package com.accolite.hibernate5.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.hibernate5.pojo.Address;
import com.accolite.hibernate5.pojo.MobileNumber;
import com.accolite.hibernate5.pojo.Person;

public class SavingDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory=ApplicationSessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		
	    //AttributeOverrides, Saving
		session.beginTransaction();
		Person person=new Person();
		person.setName("Madhukar");
		 
		Address homeAddress=new Address();
		homeAddress.setCity("hyd");
		homeAddress.setStreet("Langer Houz");
		Address resAddress=new Address();
		resAddress.setCity("Jagityal");
		resAddress.setStreet("Bheerpur");
		person.setHomeAddress(homeAddress);
		person.setResAddress(resAddress);
		session.save(person);
		session.getTransaction().commit();
		
		//OneToMany
		session.beginTransaction();
		Person person1=new Person();
		person1.setName("Madhu");
		session.save(person1);
		MobileNumber number1=new MobileNumber();
		number1.setNumber(131313);
		MobileNumber number2=new MobileNumber();
		number2.setNumber(724242);
		number1.setPerson(person1);
		number2.setPerson(person1);
		session.save(number1);
		session.save(number2);
		session.getTransaction().commit();
		
		
		//Retrieving person
		session.beginTransaction();
		Person p=session.get(Person.class, 1);
		System.out.println(p);
		session.getTransaction().commit();
		
		session.close();
		
	}
}
