package com.accolite.hibernate5.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.hibernate5.pojo.Employee;

public class InheritanceDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=ApplicationSessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setName("Madhu");
		emp.setOfficeName("Accolite");
		session.save(emp);
		
		session.getTransaction().commit();
		session.close();
	}

}
