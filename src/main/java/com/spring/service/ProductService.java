package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDao;
import com.spring.dto.ProductDTO;
import com.spring.util.EntityToDTOConverter;

@Component
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	
//	@Transactional(readOnly = true)
//	public List<ProductDTO> listAll() {
//		List<Product> productList = null;
//		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
//		
//		productList = productDao.findAll();
//		
//		productList.stream().map(item -> EntityToDTOConverter.entityToDTOConverter(item)).forEach(item -> productDTOList.add(item));
//		return productDTOList.isEmpty() ? null : productDTOList;
//	}
	
	@Transactional
	public void persistAddress(){
		productDao.insertAddress();
	}
	
	@Transactional
	public void sessionFactAddress(){
		productDao.sessionFactoryQuery();
	}
	
	@Transactional
	public void insertEmployee(){
		productDao.insertEmployee();
	}
	
}
