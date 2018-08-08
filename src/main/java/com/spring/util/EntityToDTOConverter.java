package com.spring.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.spring.dto.BillHistoryDTO;
import com.spring.dto.CategoryDTO;
import com.spring.dto.ProductDTO;
import com.spring.dto.ProductListDTO;
import com.spring.entity.BillHistory;
import com.spring.entity.Category;
import com.spring.entity.ProductList;

public class EntityToDTOConverter {
	
//	public static ProductDTO entityToDTOConverter(Product product){
//		ProductDTO productDTO = new ProductDTO();
//		
//		productDTO.setId(product.getId());
//		productDTO.setName(product.getName());
//		
//		return productDTO;
//	}
	
	public static BillHistory dtoToEntityConverter(BillHistoryDTO billDTO){
		BillHistory bill = new BillHistory();
		
		bill.setCustName(billDTO.getCustName());
		bill.setTxnTime(new Timestamp(new Date().getTime()));
		
//		if(null != billDTO.getProductList() && !billDTO.getProductList().isEmpty()){
//			for(ProductListDTO product : billDTO.getProductList()){
//				bill.addProductList(productList)
//			}
//			
//		}
		return bill;
	}
	
	public static ProductList dtoToEntityConverter(ProductListDTO prodDTO){
		ProductList product = new ProductList();
		
		product.setName(prodDTO.getName());
		product.setPrice(BigDecimal.valueOf(prodDTO.getPrice()));
		product.setCategory(dtoToEntityConverter(prodDTO.getCategoryDTO()));
		product.setBillHistory(dtoToEntityConverter(prodDTO.getBillHistoryDTO()));
		
		return product;
	}
	
	public static Category dtoToEntityConverter(CategoryDTO categoryDTO){
		Category category = new Category();
		
		category.setName(categoryDTO.getName());
		category.setTax(BigDecimal.valueOf(categoryDTO.getTax()));
		return category;
	}
	
	public static BillHistoryDTO entityToDtoConverter(BillHistory bill){
		BillHistoryDTO billHistoryDTO = null;
		
		if(null != bill){
			billHistoryDTO = new BillHistoryDTO();
			billHistoryDTO.setCustName(bill.getCustName());
			billHistoryDTO.setId(bill.getId());
			billHistoryDTO.setTxnTime(bill.getTxnTime().getTime()+"");
		}
		
		return billHistoryDTO;
	}
	
}
