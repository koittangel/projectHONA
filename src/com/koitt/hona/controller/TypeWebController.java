package com.koitt.hona.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koitt.hona.model.Product;
import com.koitt.hona.model.ProductException;
import com.koitt.hona.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeWebController {
	
	@Autowired
	private TypeService typeService;
		
	@RequestMapping("/category.do") 
	public String select (Model model, 
			HttpServletRequest request, 
			@RequestParam(value="product_type", 
			required=true) String productType) {
		
		Product product  = null;
		
		try {
			product = typeService.selectType(productType);
		} catch (Exception e) {
			model.addAttribute("error", "server");
		}
		
		model.addAttribute("product", product);
		
		return "type/category";
		
	}
	
/*	@RequestMapping(value="/category.do", method=RequestMethod.GET)
	public String typeList (Model model, 
			HttpServletRequest request,
			String productType) {
		List<Product> list = null;
		try {
			list = typeService.list();
			
		} catch (ProductException e) {
			System.out.println(e.getMessage());
			model.addAttribute("error", "server");
		}
		model.addAttribute("list", list);
		
		return "category";
		
	}*/

	

}
