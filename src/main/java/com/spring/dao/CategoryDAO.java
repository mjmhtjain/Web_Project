package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.spring.entity.Category;
import com.spring.entity.ProductList;

@Repository
public class CategoryDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Category> findAll(){
		List<Category> categList = null;
		
		TypedQuery<Category> query = em.createNamedQuery("Category.findAll", Category.class);
		categList = query.getResultList();
		
		return categList;
	}
}
