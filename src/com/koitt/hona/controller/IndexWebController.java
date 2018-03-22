package com.koitt.hona.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexWebController {

	@RequestMapping(value= {"/", "/product-list.do"}, method=RequestMethod.GET)
	public String index() {
		
		return "redirect:/product/product-list.do";
	}
}