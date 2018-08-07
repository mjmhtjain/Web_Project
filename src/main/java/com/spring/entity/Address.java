package com.spring.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the "Product" database table.
 * 
 */
@Entity
@Table(name="Address")
@NamedQuery(name="Address.findAll", query="SELECT e FROM Address e")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ", sequenceName="supplier_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ" )
    @Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name="LINE1")
	private String line1;
	
	@Column(name="ZIPCODE")
	private long zipCode;
	
	@OneToMany(mappedBy = "address")
    private Collection<Employee> employees ;
	
	public Address() {
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getLine1() {
		return line1;
	}



	public void setLine1(String line1) {
		this.line1 = line1;
	}



	public long getZipCode() {
		return zipCode;
	}



	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", line1=" + line1 + ", zipCode=" + zipCode + "]";
	}

}