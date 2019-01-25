package com.accolite.hibernate5.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.hibernate5.pojo.Worker;

public class HibernateObjectLifeCycleDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=ApplicationSessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		//Transient state
		Worker worker=new Worker();
		worker.setName("Anurag");
		worker.setDailWage(1000);
		
		//Persistent
		session.save(worker);

		session.getTransaction().commit();
		session.close();
	}
}
