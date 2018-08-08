package com.spring.dto;

public class ProductListDTO {
	private Long id;
	private String name;
	private Double price;
	private BillHistoryDTO billHistoryDTO;
	private CategoryDTO categoryDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public BillHistoryDTO getBillHistoryDTO() {
		return billHistoryDTO;
	}

	public void setBillHistoryDTO(BillHistoryDTO billHistoryDTO) {
		this.billHistoryDTO = billHistoryDTO;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}

	@Override
	public String toString() {
		return "ProductListDTO [id=" + id + ", name=" + name + ", price=" + price + ", billHistoryDTO=" + billHistoryDTO
				+ ", categoryDTO=" + categoryDTO + "]";
	}

}
