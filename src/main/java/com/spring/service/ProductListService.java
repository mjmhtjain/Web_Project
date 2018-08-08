package com.spring.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.BillHistoryDAO;
import com.spring.dao.CategoryDAO;
import com.spring.dao.ProductListDAO;
import com.spring.dto.BillHistoryDTO;
import com.spring.dto.CategoryDTO;
import com.spring.dto.ProductListDTO;
import com.spring.entity.BillHistory;
import com.spring.entity.Category;
import com.spring.entity.ProductList;
import com.spring.util.EntityToDTOConverter;

@Service
public class ProductListService {

	@Autowired
	public BillHistoryDAO billHistoryDAO;

	@Autowired
	public ProductListDAO productListDAO;

	@Autowired
	public CategoryDAO categoryDAO;

	@Transactional
	public BillHistoryDTO addProductsToBill(BillHistoryDTO billDTO) {
		BillHistoryDTO billHistoryDTO = null;
		List<Category> categoryList = null;
		Map<String, Category> categMap = null;
		BillHistory billHistory = null;

		if (null != billDTO) {
			long billId = billDTO.getId();
			billHistory = billHistoryDAO.findBillById(billId);
			categoryList = categoryDAO.findAll();
			categMap = new HashMap<String, Category>();

			if (null != categoryList && !categoryList.isEmpty()) {
				for (Category c : categoryList) {
					categMap.put(c.getName(), c);
				}
			}

			if (null != billHistory) {
				// bill found make productList
				List<ProductListDTO> prodList = billDTO.getProductList();
				List<ProductList> productEntityList = billHistory.getProductLists();
				for (ProductListDTO prodDTO : prodList) {
					ProductList prodEntity = new ProductList();
					prodEntity.setName(prodDTO.getName());
					prodEntity.setPrice(BigDecimal.valueOf(prodDTO.getPrice()));
					prodEntity.setBillHistory(billHistory);

					Category categEntity = categMap.get(prodDTO.getCategoryDTO().getName());
					if (null != categEntity) {
						prodEntity.setCategory(categEntity);
					}

//					billHistory.addProductList(prodEntity);
					productEntityList.add(prodEntity);
				}

				// persist billHistory
				billHistory = productListDAO.insertProductsToBill(billHistory);
//				billHistory = billHistoryDAO.findBillById(billHistory.getId());
				
//				List<ProductListDTO> productDTOList = billDTO.getProductList();
//				productDTOList.clear();
//				List<ProductList> productLists = billHistory.getProductLists();
//				if (null != productLists && productLists.isEmpty()) {
//					for (ProductList productList : productLists) {
//						ProductListDTO dto = new ProductListDTO();
//						dto.setId(productList.getId());
//						dto.setName(productList.getName());
//						dto.setPrice(productList.getPrice().doubleValue());
//
//						CategoryDTO categDTO = new CategoryDTO();
//						categDTO.setId(productList.getCategory().getId());
//						categDTO.setName(productList.getCategory().getName());
//						categDTO.setTax(productList.getCategory().getTax().doubleValue());
//
//						dto.setCategoryDTO(categDTO);
//						productDTOList.add(dto);
//					}
//				}

			}

		}

		return billDTO;
	}

}
