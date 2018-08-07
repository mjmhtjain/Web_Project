package com.spring.util;

import java.sql.Timestamp;
import java.util.Date;

import com.spring.dto.BillHistoryDTO;
import com.spring.dto.ProductDTO;
import com.spring.entity.BillHistory;

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
		return bill;
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
