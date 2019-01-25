package com.accolite.hibernate5.application;

import java.util.List;
//NonUnique ObjectException
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.hibernate5.pojo.Worker;

public class HQLDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=ApplicationSessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		Worker[] w = new Worker[10];
		session.beginTransaction();
		for(int i=0;i<10;i++) {
			w[i]=new Worker();
			w[i].setName("abc"+i+1);
			w[i].setDailWage(200+(i+1)*10);
			session.save(w[i]);
		}
		//Normal HQLQuery
		String sql="From Worker";
		TypedQuery query=session.createQuery(sql);
		List<Worker> workers=query.getResultList();
		System.out.println("HQL Query....All workers");
		printList(workers);
		
		//Named Query
		TypedQuery query1=session.getNamedQuery("ge5");
		query1.setParameter(1, 5);
		List<Worker> workers1=query1.getResultList();
		System.out.println("HQL NamedQuery and Parameter Binding .....workers id>5");
		printList(workers1);
		
		//Pagination
		String sql1="From Worker";
		TypedQuery query2=session.createQuery(sql1);
		query2.setFirstResult(3);
		query2.setMaxResults(5);
		List<Worker> workers2=query2.getResultList();
		System.out.println("HQL with pagination ...from 3 -->8");
		printList(workers2);
		session.getTransaction().commit();
		session.close();
		 
	}
	public static void printList(List<Worker> workers) {
		for(Worker worker:workers){
			System.out.println(worker);
		}
	}
}
