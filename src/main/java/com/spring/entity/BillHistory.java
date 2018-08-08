package com.spring.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the BILL_HISTORY database table.
 * 
 */
@Entity
@Table(name = "BILL_HISTORY")
@NamedQueries({ @NamedQuery(name = "BillHistory.findAll", query = "SELECT b FROM BillHistory b") })
public class BillHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BILL_HISTORY_ID_GENERATOR", sequenceName = "SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BILL_HISTORY_ID_GENERATOR")
	private long id;

	@Column(name = "CUST_NAME")
	private String custName;

	@Column(name = "TXN_TIME")
//	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp txnTime;

	// bi-directional many-to-one association to ProductList
	@OneToMany(mappedBy = "billHistory", cascade = CascadeType.PERSIST)
	private List<ProductList> productLists;

	public BillHistory() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Timestamp getTxnTime() {
		return this.txnTime;
	}

	public void setTxnTime(Timestamp txnTime) {
		this.txnTime = txnTime;
	}

	public List<ProductList> getProductLists() {
		return this.productLists;
	}

	public void setProductLists(List<ProductList> productLists) {
		this.productLists = productLists;
	}

	public ProductList addProductList(ProductList productList) {
		getProductLists().add(productList);
		productList.setBillHistory(this);

		return productList;
	}

	public ProductList removeProductList(ProductList productList) {
		getProductLists().remove(productList);
		productList.setBillHistory(null);

		return productList;
	}

}