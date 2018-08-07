package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.entity.Address;
import com.spring.entity.Employee;

@Component
public class ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	public void sessionFactoryQuery(){
		Session session = em.unwrap(Session.class);
		SessionFactory sessionFactory = session.getSessionFactory();
		
		if(null != sessionFactory){
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(genAddress());
			tx.commit();
			session.close();
		}
	}
	
	public void insertEmployee(){
		Session session = em.unwrap(Session.class);
		SessionFactory sessionFactory = session.getSessionFactory();
		
		if(null != sessionFactory){
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(genEmployee());
			tx.commit();
			session.close();
		}
		
//		em.persist(genEmployee());
	}
	
	private Object genEmployee() {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setName("jasf");
		emp.setAddress(genAddress());
		return emp;
	}
	
	public void fetchAddress(){
		Session session = em.unwrap(Session.class);
		SessionFactory sessionFactory = session.getSessionFactory();
		
		if(null != sessionFactory){
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(genEmployee());
			tx.commit();
			session.close();
		}
	}

	public void insertAddress(){
		Address address = genAddress();
		em.persist(address);
	}
	
	private Address genAddress(){
		Address add = new Address();
		add.setLine1("lineline");
		add.setZipCode(2324323);
		return add;
	}
	
}
