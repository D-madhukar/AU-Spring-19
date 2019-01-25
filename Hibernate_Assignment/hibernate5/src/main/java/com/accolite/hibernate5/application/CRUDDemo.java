package com.accolite.hibernate5.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.hibernate5.pojo.Worker;

public class CRUDDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=ApplicationSessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		Worker worker=new Worker();
		worker.setName("Anurag");
		worker.setDailWage(1000);
		
		//create
		session.save(worker);
		
		//read
		Worker w1=session.get(Worker.class,0);
		System.out.println(w1);
		
		//update
		worker.setDailWage(200);
		session.update(worker);
		Worker w2=session.get(Worker.class,0);
		System.out.println(w2);
		
		//Delete
		session.delete(worker);
		Worker w3=session.get(Worker.class,0);
		if(w3!=null)
			System.out.println(w2);
		else
			System.out.println("Worker Deleted");
		session.getTransaction().commit();
		session.close();

	}

}
