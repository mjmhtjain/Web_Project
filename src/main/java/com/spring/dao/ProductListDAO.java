package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.spring.entity.BillHistory;
import com.spring.entity.ProductList;
import com.spring.util.EntityToDTOConverter;

@Repository
public class ProductListDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public BillHistory insertProductsToBill(BillHistory billHistory){
		em.persist(billHistory);
		em.flush();
		return billHistory;
	}
}
