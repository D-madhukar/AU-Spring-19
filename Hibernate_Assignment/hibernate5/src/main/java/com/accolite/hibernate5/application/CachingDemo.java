package com.accolite.hibernate5.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.hibernate5.pojo.City;
import com.accolite.hibernate5.pojo.Employee;

public class CachingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=ApplicationSessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		City city=new City();
		city.setCityName("hyd");
		session.save(city);
		
		session.getTransaction().commit();
		session.close();
		
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		
		City city1 = session1.get(City.class, 1);
		session1.getTransaction().commit();
		session1.close();
		

		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		City city2=session2.get(City.class, 1);
		session2.getTransaction().commit();
		session2.close();
			
	}

}
