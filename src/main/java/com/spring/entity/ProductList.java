package com.spring.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PRODUCT_LIST database table.
 * 
 */
@Entity
@Table(name="PRODUCT_LIST")
@NamedQuery(name="ProductList.findAll", query="SELECT p FROM ProductList p")
public class ProductList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_LIST_ID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_LIST_ID_GENERATOR")
	private long id;

	private String name;

	private BigDecimal price;

	//bi-directional many-to-one association to BillHistory
	@ManyToOne
	@JoinColumn(name="BILL_FK")
	private BillHistory billHistory;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORY_FK")
	private Category category;

	public ProductList() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BillHistory getBillHistory() {
		return this.billHistory;
	}

	public void setBillHistory(BillHistory billHistory) {
		this.billHistory = billHistory;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}