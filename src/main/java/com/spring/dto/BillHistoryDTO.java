package com.spring.dto;

import java.util.List;

public class BillHistoryDTO {
	private Long id;
	private String custName;
	private String txnTime;
	private List<ProductListDTO> productList;

	public List<ProductListDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductListDTO> productList) {
		this.productList = productList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}

	@Override
	public String toString() {
		return "BillHistoryDTO [id=" + id + ", custName=" + custName + ", txnTime=" + txnTime + "]";
	}

}
