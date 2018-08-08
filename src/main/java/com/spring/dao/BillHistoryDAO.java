package com.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.spring.dto.BillHistoryDTO;
import com.spring.entity.BillHistory;

@Repository
public class BillHistoryDAO {

	@PersistenceContext
	private EntityManager em;

	public BillHistory insertBill(BillHistory bill) {

		em.persist(bill);

		if (null != bill && bill.getId() != 0) {
			bill = em.find(BillHistory.class, bill.getId());
		}
		return bill;
	}

	public BillHistory findBillById(long id) {
		BillHistory bill = null;

		if (id != 0) {
			bill = em.find(BillHistory.class, id);
		}

		return bill;
	}
}
