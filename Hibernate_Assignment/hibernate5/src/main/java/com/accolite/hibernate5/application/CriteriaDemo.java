package com.accolite.hibernate5.application;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.accolite.hibernate5.pojo.Employee;
import com.accolite.hibernate5.pojo.Worker;

public class CriteriaDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=ApplicationSessionFactory.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		for(int i=1;i<10;i++) {
			Employee emp=new Employee();
			emp.setName("abc"+i);
			emp.setOfficeName("Accolite");
			session.save(emp);
		}
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		cr.select(cb.construct(Employee.class, root.get("id"), root.get("name"),root.get("officeName")));
		List<Employee>  employees=session.createQuery(cr).getResultList();
		for(Employee emp:employees)
			System.out.println(emp);
		
		session.getTransaction().commit();
		session.close();
		
		
	}

}
