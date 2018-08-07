package com.spring.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CATEGORY database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORY_ID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORY_ID_GENERATOR")
	private long id;

	private String name;

	private BigDecimal tax;

	//bi-directional many-to-one association to ProductList
	@OneToMany(mappedBy="category")
	private List<ProductList> productLists;

	public Category() {
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

	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public List<ProductList> getProductLists() {
		return this.productLists;
	}

	public void setProductLists(List<ProductList> productLists) {
		this.productLists = productLists;
	}

	public ProductList addProductList(ProductList productList) {
		getProductLists().add(productList);
		productList.setCategory(this);

		return productList;
	}

	public ProductList removeProductList(ProductList productList) {
		getProductLists().remove(productList);
		productList.setCategory(null);

		return productList;
	}

}