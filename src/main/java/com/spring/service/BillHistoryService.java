package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BillHistoryDAO;
import com.spring.dto.BillHistoryDTO;
import com.spring.entity.BillHistory;
import com.spring.util.EntityToDTOConverter;

@Service
public class BillHistoryService {

	@Autowired
	private BillHistoryDAO billHistoryDAO;
	
	@Transactional
	public BillHistoryDTO addBillHistory(BillHistoryDTO billDTO){
		BillHistory newBill = billHistoryDAO.insertBill(EntityToDTOConverter.dtoToEntityConverter(billDTO));
		return EntityToDTOConverter.entityToDtoConverter(newBill);
	}
}
