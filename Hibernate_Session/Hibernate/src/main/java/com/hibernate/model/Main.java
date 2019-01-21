package com.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {

	public static void main(String args[]) {
		Configuration config=new Configuration();
		config.configure();
		ServiceRegistry  sr=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		SessionFactory sf=config.buildSessionFactory(sr);
		Session session=sf.openSession();
		session.beginTransaction();
		Student stud1=new Student();
		stud1.setName("madhukar");
		session.save(stud1);
		Student s1=(Student)session.get(Student.class,1);
		System.out.println(s1);
		session.getTransaction().commit();
		session.close();
	}
}
