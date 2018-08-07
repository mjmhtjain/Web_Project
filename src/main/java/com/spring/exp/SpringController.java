package com.spring.exp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.beans.Hero;
import com.spring.beans.HeroWrapper;
import com.spring.dto.BillHistoryDTO;
import com.spring.dto.ProductDTO;
import com.spring.service.BillHistoryService;
import com.spring.service.ProductService;

@Controller
public class SpringController {

	@Autowired
	private BillHistoryService billHistoryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	@RequestMapping(value = "/testing", method = RequestMethod.GET)
	@ResponseBody
	public String testMethod(Model model) {
		return "Hello testing";
	}

	@RequestMapping(value = "/new/bill", method = RequestMethod.POST)
	@ResponseBody
	public String newBill(@RequestBody BillHistoryDTO billDTO) {
		BillHistoryDTO newBill = billHistoryService.addBillHistory(billDTO);
		System.out.println(newBill);
		return "Testing newBill";
	}
//
//	@RequestMapping(value = "/testing/{id}", method = RequestMethod.GET)
//	@ResponseBody
//	public String testMethod(@PathVariable("id") Long id) {
//		return "Hello testing ... " + id;
//	}
//
//	@RequestMapping(value = "/fetch-heroes", method = RequestMethod.GET)
//	@ResponseBody
//	public HeroWrapper fetchHeroes() {
//
//		HeroWrapper heroes = new HeroWrapper();
//		return heroes;
//	}
//	
//	@RequestMapping(value = "/insert", method = RequestMethod.GET)
//	@ResponseBody
//	public String insertExp() {
//
//		productService.sessionFactAddress();
//		
//		return "SUCCESS";
//	}
//	
//	@RequestMapping(value = "/insert/emp", method = RequestMethod.GET)
//	@ResponseBody
//	public String insertEmployee() {
//
//		productService.insertEmployee();
//		
//		return "SUCCESS";
//	}
	
}
